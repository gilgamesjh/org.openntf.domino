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
package org.openntf.domino.impl;

import java.io.IOException;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;
import java.util.Date;
import java.util.EnumSet;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.logging.Logger;

import lotus.domino.NotesException;

import org.openntf.domino.ACL.Level;
import org.openntf.domino.DateTime;
import org.openntf.domino.View;
import org.openntf.domino.design.impl.DatabaseDesign;
import org.openntf.domino.transactions.DatabaseTransaction;
import org.openntf.domino.utils.DominoUtils;
import org.openntf.domino.utils.Factory;

// TODO: Auto-generated Javadoc
/**
 * The Class Database.
 */
public class Database extends Base<org.openntf.domino.Database, lotus.domino.Database> implements org.openntf.domino.Database {
	
	/** The Constant log_. */
	private static final Logger log_ = Logger.getLogger(Database.class.getName());
	/** The server_. */
	private String server_;

	/** The path_. */
	private String path_;

	/** The replid_. */
	private String replid_;

	/**
	 * Instantiates a new database.
	 * 
	 * @param delegate
	 *            the delegate
	 * @param parent
	 *            the parent
	 */
	public Database(lotus.domino.Database delegate, org.openntf.domino.Base<?> parent) {
		super(delegate, (parent instanceof org.openntf.domino.Session) ? parent : Factory.getSession(parent));
		initialize(delegate);
	}

	/**
	 * Initialize.
	 * 
	 * @param delegate
	 *            the delegate
	 */
	private void initialize(lotus.domino.Database delegate) {
		try {
			server_ = delegate.getServer();
			path_ = delegate.getFilePath();
			replid_ = delegate.getReplicaID();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#FTDomainSearch(java.lang.String, int, int, int, int, int, java.lang.String)
	 */
	public Document FTDomainSearch(String query, int maxDocs, int sortOpt, int otherOpt, int start, int count, String entryForm) {
		try {
			return Factory.fromLotus(getDelegate().FTDomainSearch(query, maxDocs, sortOpt, otherOpt, start, count, entryForm),
					Document.class, this);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return null;

		}
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.ext.Database#FTDomainSearch(java.lang.String, int, org.openntf.domino.Database.FTDomainSortOption, java.util.EnumSet, int, int, java.lang.String)
	 */
	@Override
	public Document FTDomainSearch(String query, int maxDocs, FTDomainSortOption sortOpt, EnumSet<FTDomainSearchOption> otherOpt,
			int start, int count, String entryForm) {
		int nativeOptions = 0;
		for (FTDomainSearchOption option : otherOpt) {
			nativeOptions += option.getValue();
		}

		return FTDomainSearch(query, maxDocs, sortOpt.getValue(), nativeOptions, start, count, entryForm);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#FTSearch(java.lang.String, int, int, int)
	 */
	public DocumentCollection FTSearch(String query, int maxDocs, int sortOpt, int otherOpt) {
		try {
			return Factory.fromLotus(getDelegate().FTSearch(query, maxDocs, sortOpt, otherOpt), DocumentCollection.class, this);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return null;
		}
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.ext.Database#FTSearch(java.lang.String, int, org.openntf.domino.Database.FTSortOption, java.util.EnumSet)
	 */
	@Override
	public DocumentCollection FTSearch(String query, int maxDocs, FTSortOption sortOpt, EnumSet<FTSearchOption> otherOpt) {
		int nativeOptions = 0;
		for (FTSearchOption option : otherOpt) {
			nativeOptions += option.getValue();
		}
		return FTSearch(query, maxDocs, sortOpt.getValue(), nativeOptions);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#FTSearch(java.lang.String, int)
	 */
	public DocumentCollection FTSearch(String query, int maxDocs) {
		try {
			return Factory.fromLotus(getDelegate().FTSearch(query, maxDocs), DocumentCollection.class, this);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#FTSearch(java.lang.String)
	 */
	public DocumentCollection FTSearch(String query) {
		try {
			return Factory.fromLotus(getDelegate().FTSearch(query), DocumentCollection.class, this);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return null;

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#FTSearchRange(java.lang.String, int, int, int, int)
	 */
	public DocumentCollection FTSearchRange(String query, int maxDocs, int sortOpt, int otherOpt, int start) {
		try {
			return Factory.fromLotus(getDelegate().FTSearchRange(query, maxDocs, sortOpt, otherOpt, start), DocumentCollection.class, this);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return null;

		}
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.ext.Database#FTSearchRange(java.lang.String, int, org.openntf.domino.Database.FTSortOption, java.util.EnumSet, int)
	 */
	@Override
	public DocumentCollection FTSearchRange(String query, int maxDocs, FTSortOption sortOpt, EnumSet<FTSearchOption> otherOpt, int start) {
		int nativeOptions = 0;
		for (FTSearchOption option : otherOpt) {
			nativeOptions += option.getValue();
		}
		return FTSearchRange(query, maxDocs, sortOpt.getValue(), nativeOptions, start);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#get(java.lang.Object)
	 */
	@Override
	public org.openntf.domino.Document get(Object key) {
		return this.getDocumentByKey((String) key);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#compact()
	 */
	public int compact() {
		try {
			return getDelegate().compact();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return 0;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#compactWithOptions(int, java.lang.String)
	 */
	public int compactWithOptions(int options, String spaceThreshold) {
		try {
			return getDelegate().compactWithOptions(options, spaceThreshold);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return 0;

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#compactWithOptions(int)
	 */
	public int compactWithOptions(int options) {
		try {
			return getDelegate().compactWithOptions(options);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return 0;

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#compactWithOptions(java.lang.String)
	 */
	public int compactWithOptions(String spaceThreshold) {
		try {
			return getDelegate().compactWithOptions(spaceThreshold);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return 0;

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#createCopy(java.lang.String, java.lang.String, int)
	 */
	public Database createCopy(String server, String dbFile, int maxSize) {
		try {
			return Factory.fromLotus(getDelegate().createCopy(server, dbFile, maxSize), Database.class, this);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return null;

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#containsKey(java.lang.Object)
	 */
	@Override
	public boolean containsKey(Object key) {
		return get(key) != null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#createCopy(java.lang.String, java.lang.String)
	 */
	public Database createCopy(String server, String dbFile) {
		try {
			return Factory.fromLotus(getDelegate().createCopy(server, dbFile), Database.class, this);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return null;

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#createDocument()
	 */
	public Document createDocument() {
		try {
			return Factory.fromLotus(getDelegate().createDocument(), Document.class, this);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return null;

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#createDocument(java.util.Map)
	 */
	@Override
	public Document createDocument(Map<String, Object> itemValues) {
		Document doc = this.createDocument();
		for (Map.Entry<String, Object> entry : itemValues.entrySet()) {
			doc.replaceItemValue(entry.getKey(), entry.getValue());
		}
		return doc;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#createDocument(java.lang.Object[])
	 */
	@Override
	public Document createDocument(Object... keyValuePairs) {
		Document doc = this.createDocument();
		if (keyValuePairs.length >= 2) {
			for (int i = 0; i < keyValuePairs.length; i += 2) {
				doc.replaceItemValue(keyValuePairs[i].toString(), keyValuePairs[i + 1]);
			}
		}
		return doc;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#createDocumentCollection()
	 */
	public DocumentCollection createDocumentCollection() {
		try {
			return Factory.fromLotus(getDelegate().createDocumentCollection(), DocumentCollection.class, this);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return null;

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#createFTIndex(int, boolean)
	 */
	public void createFTIndex(int options, boolean recreate) {
		try {
			getDelegate().createFTIndex(options, recreate);
		} catch (NotesException e) {
			DominoUtils.handleException(e);

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#createFromTemplate(java.lang.String, java.lang.String, boolean, int)
	 */
	public Database createFromTemplate(String server, String dbFile, boolean inherit, int maxSize) {
		try {
			return Factory.fromLotus(getDelegate().createFromTemplate(server, dbFile, inherit, maxSize), Database.class, this);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return null;

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#createFromTemplate(java.lang.String, java.lang.String, boolean)
	 */
	public Database createFromTemplate(String server, String dbFile, boolean inherit) {
		try {
			return Factory.fromLotus(getDelegate().createFromTemplate(server, dbFile, inherit), Database.class, this);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return null;

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#createNoteCollection(boolean)
	 */
	public NoteCollection createNoteCollection(boolean selectAllFlag) {
		try {
			return Factory.fromLotus(getDelegate().createNoteCollection(selectAllFlag), NoteCollection.class, this);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return null;

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#createOutline(java.lang.String, boolean)
	 */
	public Outline createOutline(String name, boolean defaultOutline) {
		try {
			return Factory.fromLotus(getDelegate().createOutline(name, defaultOutline), Outline.class, this);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return null;

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#createOutline(java.lang.String)
	 */
	public Outline createOutline(String name) {
		try {
			return Factory.fromLotus(getDelegate().createOutline(name), Outline.class, this);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return null;

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#createQueryView(java.lang.String, java.lang.String, lotus.domino.View, boolean)
	 */
	public View createQueryView(String viewName, String query, lotus.domino.View templateView, boolean prohibitDesignRefresh) {
		try {
			return Factory.fromLotus(
					getDelegate().createQueryView(viewName, query, (lotus.domino.View) toLotus(templateView), prohibitDesignRefresh),
					View.class, this);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return null;

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#createQueryView(java.lang.String, java.lang.String, lotus.domino.View)
	 */
	public View createQueryView(String viewName, String query, lotus.domino.View templateView) {
		try {
			return Factory.fromLotus(getDelegate().createQueryView(viewName, query, (lotus.domino.View) toLotus(templateView)), View.class,
					this);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return null;

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#createQueryView(java.lang.String, java.lang.String)
	 */
	public View createQueryView(String viewName, String query) {
		try {
			return Factory.fromLotus(getDelegate().createQueryView(viewName, query), View.class, this);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return null;

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#createReplica(java.lang.String, java.lang.String)
	 */
	public Database createReplica(String server, String dbFile) {
		try {
			return Factory.fromLotus(getDelegate().createReplica(server, dbFile), Database.class, this);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return null;

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#createView()
	 */
	public View createView() {
		try {
			return Factory.fromLotus(getDelegate().createView(), View.class, this);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return null;

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#createView(java.lang.String, java.lang.String, lotus.domino.View, boolean)
	 */
	public View createView(String viewName, String selectionFormula, lotus.domino.View templateView, boolean prohibitDesignRefresh) {
		try {
			return Factory.fromLotus(
					getDelegate().createView(viewName, selectionFormula, (lotus.domino.View) toLotus(templateView), prohibitDesignRefresh),
					View.class, this);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return null;

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#createView(java.lang.String, java.lang.String, lotus.domino.View)
	 */
	public View createView(String viewName, String selectionFormula, lotus.domino.View templateView) {
		try {
			return Factory.fromLotus(getDelegate().createView(viewName, selectionFormula, (lotus.domino.View) toLotus(templateView)),
					View.class, this);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return null;

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#createView(java.lang.String, java.lang.String)
	 */
	public View createView(String viewName, String selectionFormula) {
		try {
			return Factory.fromLotus(getDelegate().createView(viewName, selectionFormula), View.class, this);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return null;

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#createView(java.lang.String)
	 */
	public View createView(String viewName) {
		try {
			return Factory.fromLotus(getDelegate().createView(viewName), View.class, this);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return null;

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#enableFolder(java.lang.String)
	 */
	public void enableFolder(String folder) {
		try {
			getDelegate().enableFolder(folder);
		} catch (NotesException e) {
			DominoUtils.handleException(e);

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#fixup()
	 */
	public void fixup() {
		try {
			getDelegate().fixup();
		} catch (NotesException e) {
			DominoUtils.handleException(e);

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#fixup(int)
	 */
	public void fixup(int options) {
		try {
			getDelegate().fixup(options);
		} catch (NotesException e) {
			DominoUtils.handleException(e);

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#getACL()
	 */
	public ACL getACL() {
		try {
			return Factory.fromLotus(getDelegate().getACL(), ACL.class, this);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return null;

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#getACLActivityLog()
	 */
	@SuppressWarnings("unchecked")
	public Vector<String> getACLActivityLog() {
		try {
			return getDelegate().getACLActivityLog();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return null;

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#getAgent(java.lang.String)
	 */
	public Agent getAgent(String name) {
		try {
			return Factory.fromLotus(getDelegate().getAgent(name), Agent.class, this);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return null;

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#getAgents()
	 */
	public Vector<org.openntf.domino.Agent> getAgents() {
		try {
			return Factory.fromLotusAsVector(getDelegate().getAgents(), org.openntf.domino.Agent.class, this);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return null;

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#getAllDocuments()
	 */
	public DocumentCollection getAllDocuments() {
		try {
			return Factory.fromLotus(getDelegate().getAllDocuments(), DocumentCollection.class, this);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return null;

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#getAllReadDocuments()
	 */
	public DocumentCollection getAllReadDocuments() {
		try {
			return Factory.fromLotus(getDelegate().getAllReadDocuments(), DocumentCollection.class, this);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return null;

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#getAllReadDocuments(java.lang.String)
	 */
	public DocumentCollection getAllReadDocuments(String userName) {
		try {
			return Factory.fromLotus(getDelegate().getAllReadDocuments(userName), DocumentCollection.class, this);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return null;

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#getAllUnreadDocuments()
	 */
	public DocumentCollection getAllUnreadDocuments() {
		try {
			return Factory.fromLotus(getDelegate().getAllUnreadDocuments(), DocumentCollection.class, this);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return null;

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#getAllUnreadDocuments(java.lang.String)
	 */
	public DocumentCollection getAllUnreadDocuments(String userName) {
		try {
			return Factory.fromLotus(getDelegate().getAllUnreadDocuments(userName), DocumentCollection.class, this);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return null;

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#getCategories()
	 */
	public String getCategories() {
		try {
			return getDelegate().getCategories();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return null;

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#getCreated()
	 */
	public DateTime getCreated() {
		try {
			return Factory.fromLotus(getDelegate().getCreated(), DateTime.class, this);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return null;

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#getCurrentAccessLevel()
	 */
	public int getCurrentAccessLevel() {
		try {
			return getDelegate().getCurrentAccessLevel();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return 0;

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#getDB2Schema()
	 */
	public String getDB2Schema() {
		try {
			return getDelegate().getDB2Schema();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return null;

		}
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.ext.Database#getDesign()
	 */
	public DatabaseDesign getDesign() {
		return new DatabaseDesign(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#getDesignTemplateName()
	 */
	public String getDesignTemplateName() {
		try {
			return getDelegate().getDesignTemplateName();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return null;

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#getDocumentByID(java.lang.String)
	 */
	public Document getDocumentByID(String noteid) {
		try {
			return Factory.fromLotus(getDelegate().getDocumentByID(noteid), Document.class, this);
		} catch (NotesException e) {
			// DominoUtils.handleException(e);
			return null;

		}
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.ext.Database#getDocumentByKey(java.io.Serializable)
	 */
	public Document getDocumentByKey(Serializable key) {
		return this.getDocumentByKey(key, false);
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.ext.Database#getDocumentByKey(java.io.Serializable, boolean)
	 */
	public Document getDocumentByKey(Serializable key, boolean createOnFail) {
		try {
			if (key != null) {
				String checksum = DominoUtils.toUnid(key);
				Document doc = this.getDocumentByUNID(checksum);
				if (doc == null && createOnFail) {
					doc = this.createDocument();
					doc.setUniversalID(checksum);
					doc.replaceItemValue("$Created", new Date());
					doc.replaceItemValue("$$Key", key);
				}
				return doc;
			}
		} catch (Exception e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#getDocumentByUNID(java.lang.String)
	 */
	public Document getDocumentByUNID(String unid) {
		try {
			return Factory.fromLotus(getDelegate().getDocumentByUNID(unid), Document.class, this);
		} catch (NotesException e) {
			// DominoUtils.handleException(e);
			return null;

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#getDocumentByURL(java.lang.String, boolean, boolean, boolean, java.lang.String, java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.String, boolean)
	 */
	public Document getDocumentByURL(String url, boolean reload, boolean reloadIfModified, boolean urlList, String charSet, String webUser,
			String webPassword, String proxyUser, String proxyPassword, boolean returnImmediately) {
		try {
			// Let's have some fun with this
			try {
				URL urlObj = new URL(url);
				HttpURLConnection conn = (HttpURLConnection) urlObj.openConnection();
				conn.connect();
				System.out.println("Headers: " + conn.getHeaderFields());
				System.out.println("Content-type: " + conn.getContentType());
				conn.disconnect();
			} catch (MalformedURLException e) {
				DominoUtils.handleException(e);
			} catch (IOException e) {
				DominoUtils.handleException(e);
			}
			if (true)
				return null;

			return Factory.fromLotus(
					getDelegate().getDocumentByURL(url, reload, reloadIfModified, urlList, charSet, webUser, webPassword, proxyUser,
							proxyPassword, returnImmediately), Document.class, this);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return null;

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#getDocumentByURL(java.lang.String, boolean)
	 */
	public Document getDocumentByURL(String url, boolean reload) {
		// try {
		// return Factory.fromLotus(getDelegate().getDocumentByURL(url, reload), Document.class, this);
		// } catch (NotesException e) {
		// DominoUtils.handleException(e);
		// return null;
		//
		// }
		return this.getDocumentByURL(url, reload, reload, false, null, null, null, null, null, false);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#getFTIndexFrequency()
	 */
	public int getFTIndexFrequency() {
		try {
			return getDelegate().getFTIndexFrequency();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return 0;

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#getFileFormat()
	 */
	public int getFileFormat() {
		try {
			return getDelegate().getFileFormat();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return 0;

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#getFileName()
	 */
	public String getFileName() {
		try {
			return getDelegate().getFileName();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return null;

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#getFilePath()
	 */
	public String getFilePath() {
		return path_;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#getFolderReferencesEnabled()
	 */
	public boolean getFolderReferencesEnabled() {
		try {
			return getDelegate().getFolderReferencesEnabled();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return false;

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#getForm(java.lang.String)
	 */
	public Form getForm(String name) {
		try {
			return Factory.fromLotus(getDelegate().getForm(name), Form.class, this);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return null;

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#getForms()
	 */
	public Vector<org.openntf.domino.Form> getForms() {
		try {
			return Factory.fromLotusAsVector(getDelegate().getForms(), org.openntf.domino.Form.class, this);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return null;

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#getHttpURL()
	 */
	public String getHttpURL() {
		try {
			return getDelegate().getHttpURL();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return null;

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#getLastFTIndexed()
	 */
	public DateTime getLastFTIndexed() {
		try {
			return Factory.fromLotus(getDelegate().getLastFTIndexed(), DateTime.class, Factory.getSession(this));
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return null;

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#getLastFixup()
	 */
	public DateTime getLastFixup() {
		try {
			return Factory.fromLotus(getDelegate().getLastFixup(), DateTime.class, Factory.getSession(this));
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return null;

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#getLastModified()
	 */
	public DateTime getLastModified() {
		try {
			return Factory.fromLotus(getDelegate().getLastModified(), DateTime.class, Factory.getSession(this));
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return null;

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#getLimitRevisions()
	 */
	public double getLimitRevisions() {
		try {
			return getDelegate().getLimitRevisions();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return 0d;

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#getLimitUpdatedBy()
	 */
	public double getLimitUpdatedBy() {
		try {
			return getDelegate().getLimitUpdatedBy();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return 0d;

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#getListInDbCatalog()
	 */
	public boolean getListInDbCatalog() {
		try {
			return getDelegate().getListInDbCatalog();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return false;

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#getManagers()
	 */
	@SuppressWarnings("unchecked")
	public Vector<String> getManagers() {
		try {
			return getDelegate().getManagers();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return null;

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#getMaxSize()
	 */
	public long getMaxSize() {
		try {
			return getDelegate().getMaxSize();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return 0L;

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#getModifiedDocuments()
	 */
	public DocumentCollection getModifiedDocuments() {
		try {
			return Factory.fromLotus(getDelegate().getModifiedDocuments(), DocumentCollection.class, this);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return null;

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#getModifiedDocuments(lotus.domino.DateTime, int)
	 */
	public DocumentCollection getModifiedDocuments(lotus.domino.DateTime since, int noteClass) {
		try {
			DocumentCollection result;
			lotus.domino.DateTime dt = (lotus.domino.DateTime) toLotus(since);
			result = Factory.fromLotus(getDelegate().getModifiedDocuments(dt, noteClass), DocumentCollection.class, this);
			dt.recycle();
			return result;
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return null;

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#getModifiedDocuments(lotus.domino.DateTime)
	 */
	public DocumentCollection getModifiedDocuments(lotus.domino.DateTime since) {
		return getModifiedDocuments(since, 1);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#getNotesURL()
	 */
	public String getNotesURL() {
		try {
			return getDelegate().getNotesURL();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return null;

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#getOption(int)
	 */
	public boolean getOption(int optionName) {
		try {
			return getDelegate().getOption(optionName);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return false;

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#getOutline(java.lang.String)
	 */
	public Outline getOutline(String outlineName) {
		try {
			return Factory.fromLotus(getDelegate().getOutline(outlineName), Outline.class, this);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return null;

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.impl.Base#getParent()
	 */
	@Override
	public Session getParent() {
		return (Session) super.getParent();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#getPercentUsed()
	 */
	public double getPercentUsed() {
		try {
			return getDelegate().getPercentUsed();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return 0d;

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#getProfileDocCollection(java.lang.String)
	 */
	public DocumentCollection getProfileDocCollection(String profileName) {
		try {
			return Factory.fromLotus(getDelegate().getProfileDocCollection(profileName), DocumentCollection.class, this);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return null;

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#getProfileDocument(java.lang.String, java.lang.String)
	 */
	public Document getProfileDocument(String profileName, String key) {
		try {
			return Factory.fromLotus(getDelegate().getProfileDocument(profileName, key), Document.class, this);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return null;

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#getReplicaID()
	 */
	public String getReplicaID() {
		return replid_;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#getReplicationInfo()
	 */
	public Replication getReplicationInfo() {
		try {
			return Factory.fromLotus(getDelegate().getReplicationInfo(), Replication.class, this);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return null;

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#getServer()
	 */
	public String getServer() {
		return server_;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#getSize()
	 */
	public double getSize() {
		try {
			return getDelegate().getSize();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return 0d;

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#getSizeQuota()
	 */
	public int getSizeQuota() {
		try {
			return getDelegate().getSizeQuota();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return 0;

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#getSizeWarning()
	 */
	public long getSizeWarning() {
		try {
			return getDelegate().getSizeWarning();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return 0L;

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#getTemplateName()
	 */
	public String getTemplateName() {
		try {
			return getDelegate().getTemplateName();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return null;

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#getTitle()
	 */
	public String getTitle() {
		try {
			return getDelegate().getTitle();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return null;

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#getType()
	 */
	public int getType() {
		try {
			return getDelegate().getType();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return 0;

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#getURL()
	 */
	public String getURL() {
		try {
			return getDelegate().getURL();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return null;

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#getURLHeaderInfo(java.lang.String, java.lang.String, java.lang.String, java.lang.String,
	 * java.lang.String, java.lang.String)
	 */
	public String getURLHeaderInfo(String url, String header, String webUser, String webPassword, String proxyUser, String proxyPassword) {
		try {
			return getDelegate().getURLHeaderInfo(url, header, webUser, webPassword, proxyUser, proxyPassword);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return null;

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#getUndeleteExpireTime()
	 */
	public int getUndeleteExpireTime() {
		try {
			return getDelegate().getUndeleteExpireTime();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return 0;

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#getView(java.lang.String)
	 */
	public View getView(String name) {
		try {
			View result = Factory.fromLotus(getDelegate().getView(name), View.class, this);
			result.setAutoUpdate(false);
			return result;
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return null;

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#getViews()
	 */
	public Vector<org.openntf.domino.View> getViews() {
		try {
			return Factory.fromLotusAsVector(getDelegate().getViews(), org.openntf.domino.View.class, this);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return null;

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#grantAccess(java.lang.String, int)
	 */
	public void grantAccess(String name, int level) {
		try {
			getDelegate().grantAccess(name, level);
		} catch (NotesException e) {
			DominoUtils.handleException(e);

		}
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.ext.Database#grantAccess(java.lang.String, org.openntf.domino.ACL.Level)
	 */
	@Override
	public void grantAccess(String name, Level level) {
		grantAccess(name, level.getValue());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#isAllowOpenSoftDeleted()
	 */
	public boolean isAllowOpenSoftDeleted() {
		try {
			return getDelegate().isAllowOpenSoftDeleted();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return false;

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#isClusterReplication()
	 */
	public boolean isClusterReplication() {
		try {
			return getDelegate().isClusterReplication();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return false;

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#isConfigurationDirectory()
	 */
	public boolean isConfigurationDirectory() {
		try {
			return getDelegate().isConfigurationDirectory();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return false;

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#isCurrentAccessPublicReader()
	 */
	public boolean isCurrentAccessPublicReader() {
		try {
			return getDelegate().isCurrentAccessPublicReader();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return false;

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#isCurrentAccessPublicWriter()
	 */
	public boolean isCurrentAccessPublicWriter() {
		try {
			return getDelegate().isCurrentAccessPublicWriter();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return false;

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#isDB2()
	 */
	public boolean isDB2() {
		try {
			return getDelegate().isDB2();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return false;

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#isDelayUpdates()
	 */
	public boolean isDelayUpdates() {
		try {
			return getDelegate().isDelayUpdates();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return false;

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#isDesignLockingEnabled()
	 */
	public boolean isDesignLockingEnabled() {
		try {
			return getDelegate().isDesignLockingEnabled();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return false;

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#isDirectoryCatalog()
	 */
	public boolean isDirectoryCatalog() {
		try {
			return getDelegate().isDirectoryCatalog();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return false;

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#isDocumentLockingEnabled()
	 */
	public boolean isDocumentLockingEnabled() {
		try {
			return getDelegate().isDocumentLockingEnabled();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return false;

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#isFTIndexed()
	 */
	public boolean isFTIndexed() {
		try {
			return getDelegate().isFTIndexed();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return false;

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#isInMultiDbIndexing()
	 */
	public boolean isInMultiDbIndexing() {
		try {
			return getDelegate().isInMultiDbIndexing();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return false;

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#isInService()
	 */
	public boolean isInService() {
		try {
			return getDelegate().isInService();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return false;

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#isLink()
	 */
	public boolean isLink() {
		try {
			return getDelegate().isLink();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return false;

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#isMultiDbSearch()
	 */
	public boolean isMultiDbSearch() {
		try {
			return getDelegate().isMultiDbSearch();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return false;

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#isOpen()
	 */
	public boolean isOpen() {
		try {
			return getDelegate().isOpen();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return false;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#isPendingDelete()
	 */
	public boolean isPendingDelete() {
		try {
			return getDelegate().isPendingDelete();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return false;

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#isPrivateAddressBook()
	 */
	public boolean isPrivateAddressBook() {
		try {
			return getDelegate().isPrivateAddressBook();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return false;

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#isPublicAddressBook()
	 */
	public boolean isPublicAddressBook() {
		try {
			return getDelegate().isPublicAddressBook();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return false;

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#markForDelete()
	 */
	public void markForDelete() {
		try {
			getDelegate().markForDelete();
		} catch (NotesException e) {
			DominoUtils.handleException(e);

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#open()
	 */
	public boolean open() {
		try {
			return getDelegate().open();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return false;

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#openByReplicaID(java.lang.String, java.lang.String)
	 */
	public boolean openByReplicaID(String server, String replicaId) {
		try {
			return getDelegate().openByReplicaID(server, replicaId);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return false;

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#openIfModified(java.lang.String, java.lang.String, lotus.domino.DateTime)
	 */
	public boolean openIfModified(String server, String dbFile, lotus.domino.DateTime modifiedSince) {
		try {
			boolean result = false;
			lotus.domino.DateTime dt = (lotus.domino.DateTime) toLotus(modifiedSince);
			result = getDelegate().openIfModified(server, dbFile, dt);
			dt.recycle();
			return result;
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return false;

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#openWithFailover(java.lang.String, java.lang.String)
	 */
	public boolean openWithFailover(String server, String dbFile) {
		try {
			return getDelegate().openWithFailover(server, dbFile);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return false;

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#queryAccess(java.lang.String)
	 */
	public int queryAccess(String name) {
		try {
			return getDelegate().queryAccess(name);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return 0;

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#queryAccessPrivileges(java.lang.String)
	 */
	public int queryAccessPrivileges(String name) {
		try {
			return getDelegate().queryAccessPrivileges(name);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return 0;

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#queryAccessRoles(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	public Vector<String> queryAccessRoles(String name) {
		try {
			return getDelegate().queryAccessRoles(name);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#remove()
	 */
	public void remove() {
		try {
			getDelegate().remove();
		} catch (NotesException e) {
			DominoUtils.handleException(e);

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#removeFTIndex()
	 */
	public void removeFTIndex() {
		try {
			getDelegate().removeFTIndex();
		} catch (NotesException e) {
			DominoUtils.handleException(e);

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#replicate(java.lang.String)
	 */
	public boolean replicate(String server) {
		try {
			return getDelegate().replicate(server);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return false;

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#revokeAccess(java.lang.String)
	 */
	public void revokeAccess(String name) {
		try {
			getDelegate().revokeAccess(name);
		} catch (NotesException e) {
			DominoUtils.handleException(e);

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#search(java.lang.String, lotus.domino.DateTime, int)
	 */
	public DocumentCollection search(String formula, lotus.domino.DateTime startDate, int maxDocs) {
		try {
			DocumentCollection result;
			lotus.domino.DateTime dt = (lotus.domino.DateTime) toLotus(startDate);
			result = Factory.fromLotus(getDelegate().search(formula, dt, maxDocs), DocumentCollection.class, this);
			dt.recycle();
			return result;
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return null;

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#search(java.lang.String, lotus.domino.DateTime)
	 */
	public DocumentCollection search(String formula, lotus.domino.DateTime startDate) {
		return search(formula, startDate, 0);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#search(java.lang.String)
	 */
	public DocumentCollection search(String formula) {
		try {
			return Factory.fromLotus(getDelegate().search(formula), DocumentCollection.class, this);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
			return null;

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#setAllowOpenSoftDeleted(boolean)
	 */
	public void setAllowOpenSoftDeleted(boolean flag) {
		try {
			getDelegate().setAllowOpenSoftDeleted(flag);
		} catch (NotesException e) {
			DominoUtils.handleException(e);

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#setCategories(java.lang.String)
	 */
	public void setCategories(String categories) {
		try {
			getDelegate().setCategories(categories);
		} catch (NotesException e) {
			DominoUtils.handleException(e);

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#setDelayUpdates(boolean)
	 */
	public void setDelayUpdates(boolean flag) {
		try {
			getDelegate().setDelayUpdates(flag);
		} catch (NotesException e) {
			DominoUtils.handleException(e);

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#setDesignLockingEnabled(boolean)
	 */
	public void setDesignLockingEnabled(boolean flag) {
		try {
			getDelegate().setDesignLockingEnabled(flag);
		} catch (NotesException e) {
			DominoUtils.handleException(e);

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#setDocumentLockingEnabled(boolean)
	 */
	public void setDocumentLockingEnabled(boolean flag) {
		try {
			getDelegate().setDocumentLockingEnabled(flag);
		} catch (NotesException e) {
			DominoUtils.handleException(e);

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#setFTIndexFrequency(int)
	 */
	public void setFTIndexFrequency(int frequency) {
		try {
			getDelegate().setFTIndexFrequency(frequency);
		} catch (NotesException e) {
			DominoUtils.handleException(e);

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#setFolderReferencesEnabled(boolean)
	 */
	public void setFolderReferencesEnabled(boolean flag) {
		try {
			getDelegate().setFolderReferencesEnabled(flag);
		} catch (NotesException e) {
			DominoUtils.handleException(e);

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#setInMultiDbIndexing(boolean)
	 */
	public void setInMultiDbIndexing(boolean flag) {
		try {
			getDelegate().setInMultiDbIndexing(flag);
		} catch (NotesException e) {
			DominoUtils.handleException(e);

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#setInService(boolean)
	 */
	public void setInService(boolean flag) {
		try {
			getDelegate().setInService(flag);
		} catch (NotesException e) {
			DominoUtils.handleException(e);

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#setLimitRevisions(double)
	 */
	public void setLimitRevisions(double revisions) {
		try {
			getDelegate().setLimitRevisions(revisions);
		} catch (NotesException e) {
			DominoUtils.handleException(e);

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#setLimitUpdatedBy(double)
	 */
	public void setLimitUpdatedBy(double updatedBys) {
		try {
			getDelegate().setLimitUpdatedBy(updatedBys);
		} catch (NotesException e) {
			DominoUtils.handleException(e);

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#setListInDbCatalog(boolean)
	 */
	public void setListInDbCatalog(boolean flag) {
		try {
			getDelegate().setListInDbCatalog(flag);
		} catch (NotesException e) {
			DominoUtils.handleException(e);

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#setOption(int, boolean)
	 */
	public void setOption(int optionName, boolean flag) {
		try {
			getDelegate().setOption(optionName, flag);
		} catch (NotesException e) {
			DominoUtils.handleException(e);

		}
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.ext.Database#setOption(org.openntf.domino.Database.DBOption, boolean)
	 */
	public void setOption(DBOption optionName, boolean flag) {
		setOption(optionName.getValue(), flag);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#setSizeQuota(int)
	 */
	public void setSizeQuota(int quota) {
		try {
			getDelegate().setSizeQuota(quota);
		} catch (NotesException e) {
			DominoUtils.handleException(e);

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#setSizeWarning(int)
	 */
	public void setSizeWarning(int warning) {
		try {
			getDelegate().setSizeWarning(warning);
		} catch (NotesException e) {
			DominoUtils.handleException(e);

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#setTitle(java.lang.String)
	 */
	public void setTitle(final String title) {
		try {
			getDelegate().setTitle(title);
		} catch (NotesException e) {
			DominoUtils.handleException(e);

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#setUndeleteExpireTime(int)
	 */
	public void setUndeleteExpireTime(int hours) {
		try {
			getDelegate().setUndeleteExpireTime(hours);
		} catch (NotesException e) {
			DominoUtils.handleException(e);

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#sign()
	 */
	public void sign() {
		try {
			getDelegate().sign();
		} catch (NotesException e) {
			DominoUtils.handleException(e);

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#sign(int, boolean, java.lang.String, boolean)
	 */
	public void sign(int documentType, boolean existingSigsOnly, String name, boolean nameIsNoteid) {
		try {
			getDelegate().sign(documentType, existingSigsOnly, name, nameIsNoteid);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.ext.Database#sign(org.openntf.domino.Database.SignDocType, boolean, java.lang.String, boolean)
	 */
	public void sign(SignDocType documentType, boolean existingSigsOnly, String name, boolean nameIsNoteid) {
		this.sign(documentType.getValue(), existingSigsOnly, name, nameIsNoteid);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#sign(int, boolean, java.lang.String)
	 */
	public void sign(int documentType, boolean existingSigsOnly, String name) {
		try {
			getDelegate().sign(documentType, existingSigsOnly, name);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.ext.Database#sign(org.openntf.domino.Database.SignDocType, boolean, java.lang.String)
	 */
	public void sign(SignDocType documentType, boolean existingSigsOnly, String name) {
		this.sign(documentType.getValue(), existingSigsOnly, name);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#sign(int, boolean)
	 */
	public void sign(int documentType, boolean existingSigsOnly) {
		try {
			getDelegate().sign(documentType, existingSigsOnly);
		} catch (NotesException e) {
			DominoUtils.handleException(e);

		}
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.ext.Database#sign(org.openntf.domino.Database.SignDocType, boolean)
	 */
	public void sign(SignDocType documentType, boolean existingSigsOnly) {
		this.sign(documentType.getValue(), existingSigsOnly);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#sign(int)
	 */
	public void sign(int documentType) {
		try {
			getDelegate().sign(documentType);
		} catch (NotesException e) {
			DominoUtils.handleException(e);

		}
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.ext.Database#sign(org.openntf.domino.Database.SignDocType)
	 */
	public void sign(SignDocType documentType) {
		this.sign(documentType.getValue());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.Database#updateFTIndex(boolean)
	 */
	public void updateFTIndex(boolean create) {
		try {
			getDelegate().updateFTIndex(create);
		} catch (NotesException e) {
			DominoUtils.handleException(e);

		}
	}

	/** The current transaction_. */
	private DatabaseTransaction currentTransaction_;

	/* (non-Javadoc)
	 * @see org.openntf.domino.ext.Database#startTransaction()
	 */
	@Override
	public DatabaseTransaction startTransaction() {
		if (currentTransaction_ == null) {
			currentTransaction_ = new DatabaseTransaction(this);
		}
		return currentTransaction_;
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.ext.Database#closeTransaction()
	 */
	public void closeTransaction() {
		currentTransaction_ = null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.ext.Database#getTransaction()
	 */
	public DatabaseTransaction getTransaction() {
		return currentTransaction_;
	}

	/*
	 * Map methods
	 */

	/* (non-Javadoc)
	 * @see java.util.Map#clear()
	 */
	@Override
	public void clear() {
		// Oh, dear god, no!
		throw new UnsupportedOperationException();
	}

	/* (non-Javadoc)
	 * @see java.util.Map#containsValue(java.lang.Object)
	 */
	@Override
	public boolean containsValue(Object value) {
		throw new UnsupportedOperationException();
	}

	/* (non-Javadoc)
	 * @see java.util.Map#entrySet()
	 */
	@Override
	public Set<java.util.Map.Entry<String, org.openntf.domino.Document>> entrySet() {
		// TODO Maybe turn NoteCollection into this?
		return null;
	}

	/* (non-Javadoc)
	 * @see java.util.Map#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return this.getAllDocuments().getCount() > 0;
	}

	/* (non-Javadoc)
	 * @see java.util.Map#keySet()
	 */
	@Override
	public Set<String> keySet() {
		// TODO Implement this
		return null;
	}

	/* (non-Javadoc)
	 * @see java.util.Map#put(java.lang.Object, java.lang.Object)
	 */
	@Override
	public org.openntf.domino.Document put(String key, org.openntf.domino.Document value) {
		// Ignore the value for now
		if (key != null) {
			Document doc = this.getDocumentByKey(key);
			if (doc == null) {
				doc = this.getDocumentByKey(key, true);
				doc.save();
				return null;
			} else {
				return doc;
			}
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see java.util.Map#putAll(java.util.Map)
	 */
	@Override
	public void putAll(Map<? extends String, ? extends org.openntf.domino.Document> m) {
		// TODO Implement this?
	}

	/* (non-Javadoc)
	 * @see java.util.Map#remove(java.lang.Object)
	 */
	@Override
	public org.openntf.domino.Document remove(Object key) {
		if (key != null) {
			Document doc = this.getDocumentByKey(key.toString());
			if (doc != null) {
				doc.remove(false);
			}

			return null;
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see java.util.Map#size()
	 */
	@Override
	public int size() {
		return this.getAllDocuments().getCount();
	}

	/* (non-Javadoc)
	 * @see java.util.Map#values()
	 */
	@Override
	public Collection<org.openntf.domino.Document> values() {
		return this.createDocumentCollection();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.impl.Base#getDelegate()
	 */
	@Override
	protected lotus.domino.Database getDelegate() {
		lotus.domino.Database db = super.getDelegate();
		try {
			db.isFTIndexed();
		} catch (NotesException e) {
			resurrect();
		}
		return super.getDelegate();
	}

	/**
	 * Resurrect.
	 */
	public void resurrect() { // should only happen if the delegate has been destroyed somehow.
		// TODO: Currently gets session. Need to get session, sessionAsSigner or sessionAsSignerWithFullAccess, as appropriate somwhow
		Session rawSessionUs = (Session) Factory.getSession();
		lotus.domino.Session rawSession = (lotus.domino.Session) rawSessionUs.getDelegate();
		try {
			lotus.domino.Database d = rawSession.getDatabase(server_, path_);
			setDelegate(d);
			if (log_.isLoggable(java.util.logging.Level.FINE)) {
				Throwable t = new Throwable();
				StackTraceElement[] elements = t.getStackTrace();
				log_.log(java.util.logging.Level.FINE, "Database " + (server_.length() < 1 ? "" : server_ + "!!") + path_
						+ "had been recycled and was auto-restored. Changes may have been lost.");

				log_.log(java.util.logging.Level.FINER, elements[1].getClassName() + "." + elements[1].getMethodName() + " ( line "
						+ elements[1].getLineNumber() + ")");
				log_.log(java.util.logging.Level.FINER, elements[2].getClassName() + "." + elements[2].getMethodName() + " ( line "
						+ elements[2].getLineNumber() + ")");
				log_.log(java.util.logging.Level.FINER, elements[3].getClassName() + "." + elements[3].getMethodName() + " ( line "
						+ elements[3].getLineNumber() + ")");
				log_.log(java.util.logging.Level.FINE,
						"If you are using this Database in XPages and have attempted to hold it in an scoped variable between requests, this behavior is normal.");

			}
		} catch (Exception e) {
			DominoUtils.handleException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.types.SessionDescendant#getAncestorSession()
	 */
	@Override
	public Session getAncestorSession() {
		return this.getParent();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.ext.Database#compactWithOptions(java.util.EnumSet)
	 */
	@Override
	public int compactWithOptions(EnumSet<CompactOption> options) {
		int nativeOptions = 0;
		for (CompactOption option : options) {
			nativeOptions += option.getValue();
		}
		return compactWithOptions(nativeOptions);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.ext.Database#compactWithOptions(java.util.EnumSet, java.lang.String)
	 */
	@Override
	public int compactWithOptions(EnumSet<CompactOption> options, String spaceThreshold) {
		int nativeOptions = 0;
		for (CompactOption option : options) {
			nativeOptions += option.getValue();
		}
		return compactWithOptions(nativeOptions, spaceThreshold);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.ext.Database#createFTIndex(java.util.EnumSet, boolean)
	 */
	@Override
	public void createFTIndex(EnumSet<FTIndexOption> options, boolean recreate) {
		int nativeOptions = 0;
		for (FTIndexOption option : options) {
			nativeOptions += option.getValue();
		}
		createFTIndex(nativeOptions, recreate);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.ext.Database#fixup(java.util.EnumSet)
	 */
	@Override
	public void fixup(EnumSet<FixupOption> options) {
		int nativeOptions = 0;
		for (FixupOption option : options) {
			nativeOptions += option.getValue();
		}
		fixup(nativeOptions);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.ext.Database#getModifiedDocuments(lotus.domino.DateTime, org.openntf.domino.Database.ModifiedDocClass)
	 */
	@Override
	public DocumentCollection getModifiedDocuments(lotus.domino.DateTime since, ModifiedDocClass noteClass) {
		return getModifiedDocuments(since, noteClass.getValue());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.ext.Database#getOption(org.openntf.domino.Database.DBOption)
	 */
	@Override
	public boolean getOption(DBOption optionName) {
		return getOption(optionName.getValue());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.ext.Database#setFTIndexFrequency(org.openntf.domino.Database.FTIndexFrequency)
	 */
	@Override
	public void setFTIndexFrequency(FTIndexFrequency frequency) {
		setFTIndexFrequency(frequency.getValue());
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.ext.Database#getDominoServer()
	 */
	public lotus.notes.addins.DominoServer getDominoServer() {
		try {
			lotus.notes.addins.DominoServer server = new lotus.notes.addins.DominoServer(getServer());
			return server;
		} catch (Exception e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.ext.Database#refreshDesign()
	 */
	public void refreshDesign() {
		try {
			lotus.notes.addins.DominoServer server = getDominoServer();
			server.refreshDesign(getFilePath());
		} catch (Exception e) {
			DominoUtils.handleException(e);
		}
	}
}
