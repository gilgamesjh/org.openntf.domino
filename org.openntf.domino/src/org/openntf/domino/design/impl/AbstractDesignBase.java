/*
 * Copyright OpenNTF 2013
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at:
 * 
 * http://www.apache.org/licenses/LICENSE-2.0 
 * 
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or 
 * implied. See the License for the specific language governing 
 * permissions and limitations under the License.
 */
package org.openntf.domino.design.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.openntf.domino.Database;
import org.openntf.domino.Document;
import org.openntf.domino.DxlImporter;
import org.openntf.domino.Session;
import org.openntf.domino.design.DesignBase;
import org.openntf.domino.utils.DominoUtils;
import org.openntf.domino.utils.xml.XMLDocument;
import org.openntf.domino.utils.xml.XMLNode;
import org.xml.sax.SAXException;

// TODO: Auto-generated Javadoc
/**
 * The Class AbstractDesignBase.
 * 
 * @author jgallagher
 */
public abstract class AbstractDesignBase implements DesignBase {
	
	/** The Constant log_. */
	@SuppressWarnings("unused")
	private static final Logger log_ = Logger.getLogger(AbstractDesignBase.class.getName());
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The document_. */
	private Document document_;
	
	/** The dxl_. */
	private XMLDocument dxl_;

	/** The title_. */
	private String title_ = null;
	
	/** The aliases_. */
	private List<String> aliases_ = null;

	/**
	 * Instantiates a new abstract design base.
	 * 
	 * @param document
	 *            the document
	 */
	public AbstractDesignBase(final Document document) {
		document_ = document;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.design.DesignBase#getAliases()
	 */
	@Override
	public List<String> getAliases() {
		if (title_ == null) {
			fetchTitle();
		}
		return new ArrayList<String>(aliases_);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.design.DesignBase#getName()
	 */
	@Override
	public String getName() {
		if (title_ == null) {
			fetchTitle();
		}
		return title_;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.design.DesignBase#isHideFromNotes()
	 */
	@Override
	public boolean isHideFromNotes() {
		return getFlags().contains("n");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.design.DesignBase#isHideFromWeb()
	 */
	@Override
	public boolean isHideFromWeb() {
		return getFlags().contains("w");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.design.DesignBase#isNeedsRefresh()
	 */
	@Override
	public boolean isNeedsRefresh() {
		return getFlags().contains("$");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.design.DesignBase#isPreventChanges()
	 */
	@Override
	public boolean isPreventChanges() {
		return getFlags().contains("P");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.design.DesignBase#isPropagatePreventChanges()
	 */
	@Override
	public boolean isPropagatePreventChanges() {
		return getFlags().contains("r");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.types.Design#getDocument()
	 */
	@Override
	public Document getDocument() {
		return document_;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.types.Design#getNoteID()
	 */
	@Override
	public String getNoteID() {
		return getDocument().getNoteID();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.types.Design#getUniversalID()
	 */
	@Override
	public String getUniversalID() {
		return getDocument().getUniversalID();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.types.DatabaseDescendant#getAncestorDatabase()
	 */
	@Override
	public Database getAncestorDatabase() {
		return getDocument().getAncestorDatabase();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.types.SessionDescendant#getAncestorSession()
	 */
	@Override
	public Session getAncestorSession() {
		return this.getAncestorDatabase().getAncestorSession();
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.design.DesignBase#save()
	 */
	public void save() {
		DxlImporter importer = getAncestorSession().createDxlImporter();
		importer.setDesignImportOption(DxlImporter.DesignImportOption.REPLACE_ELSE_CREATE);
		importer.setReplicaRequiredForReplaceOrUpdate(false);
		Database database = getAncestorDatabase();
		try {
			importer.importDxl(getDxl().getXml(), database);
		} catch (IOException e) {
			DominoUtils.handleException(e);
			return;
		}
		String noteId = importer.getFirstImportedNoteID();
		document_ = database.getDocumentByID(noteId);
	}

	/**
	 * Gets the flags.
	 * 
	 * @return the flags
	 */
	protected String getFlags() {
		return document_.getItemValueString("$Flags");
	}

	/**
	 * Fetch title.
	 */
	@SuppressWarnings("unchecked")
	private void fetchTitle() {
		// Sometimes $TITLE is a multi-value field of title + aliases.
		// Sometimes it's a |-delimited single value.
		// Meh!

		List<String> titles = document_.getItemValue("$TITLE");
		if (titles.size() == 0) {
			String titleField = document_.getItemValueString("$TITLE");
			if (titleField.contains("|")) {
				String[] bits = titleField.split("\\|");
				title_ = bits[0];
				aliases_ = new ArrayList<String>(bits.length - 1);
				for (int i = 1; i < bits.length; i++) {
					aliases_.add(bits[i]);
				}
			} else {
				title_ = titleField;
				aliases_ = new ArrayList<String>(0);
			}
		} else if (titles.size() == 1) {
			title_ = titles.get(0);
			aliases_ = new ArrayList<String>(0);
		} else {
			title_ = titles.get(0);
			aliases_ = titles.subList(1, titles.size());
		}

	}

	/**
	 * Gets the dxl.
	 * 
	 * @return the dxl
	 */
	protected XMLDocument getDxl() {
		if (dxl_ == null) {
			dxl_ = new XMLDocument();
			try {
				dxl_.loadString(getDocument().generateXML());
			} catch (SAXException e) {
				DominoUtils.handleException(e);
				return null;
			} catch (IOException e) {
				DominoUtils.handleException(e);
				return null;
			} catch (ParserConfigurationException e) {
				DominoUtils.handleException(e);
				return null;
			}
		}
		return dxl_;
	}

	/**
	 * Gets the dxl node.
	 * 
	 * @param xpathString
	 *            the xpath string
	 * @return the dxl node
	 */
	protected XMLNode getDxlNode(final String xpathString) {
		try {
			return getDxl().selectSingleNode(xpathString);
		} catch (XPathExpressionException e) {
			DominoUtils.handleException(e);
			return null;
		}
	}
}
