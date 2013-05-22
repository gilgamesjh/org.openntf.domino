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

import java.util.Vector;

import lotus.domino.NotesException;

import org.openntf.domino.DocumentCollection;
import org.openntf.domino.Session;
import org.openntf.domino.utils.DominoUtils;
import org.openntf.domino.utils.Factory;

// TODO: Auto-generated Javadoc
/**
 * The Class View.
 */
public class View extends Base<org.openntf.domino.View, lotus.domino.View> implements org.openntf.domino.View {

	/**
	 * Instantiates a new view.
	 * 
	 * @param delegate
	 *            the delegate
	 * @param parent
	 *            the parent
	 */
	public View(lotus.domino.View delegate, org.openntf.domino.Base<?> parent) {
		super(delegate, Factory.getParentDatabase(parent));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#FTSearch(java.lang.String)
	 */
	@Override
	public int FTSearch(String query) {
		try {
			return getDelegate().FTSearch(query);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return -1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#FTSearch(java.lang.String, int)
	 */
	@Override
	public int FTSearch(String query, int maxDocs) {
		try {
			return getDelegate().FTSearch(query, maxDocs);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return -1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#FTSearchSorted(java.lang.String)
	 */
	@Override
	public int FTSearchSorted(String query) {
		try {
			return getDelegate().FTSearchSorted(query);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return -1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#FTSearchSorted(java.lang.String, int)
	 */
	@Override
	public int FTSearchSorted(String query, int maxDocs) {
		try {
			return getDelegate().FTSearchSorted(query, maxDocs);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return -1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#FTSearchSorted(java.lang.String, int, int)
	 */
	@Override
	public int FTSearchSorted(String query, int maxDocs, int column) {
		try {
			return getDelegate().FTSearchSorted(query, maxDocs, column);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return -1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#FTSearchSorted(java.lang.String, int, int, boolean, boolean, boolean, boolean)
	 */
	@Override
	public int FTSearchSorted(String query, int maxDocs, int column, boolean ascending, boolean exact, boolean variants, boolean fuzzy) {
		try {
			return getDelegate().FTSearchSorted(query, maxDocs, column, ascending, exact, variants, fuzzy);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return -1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#FTSearchSorted(java.lang.String, int, java.lang.String)
	 */
	@Override
	public int FTSearchSorted(String query, int maxDocs, String column) {
		try {
			return getDelegate().FTSearchSorted(query, maxDocs, column);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return -1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#FTSearchSorted(java.lang.String, int, java.lang.String, boolean, boolean, boolean, boolean)
	 */
	@Override
	public int FTSearchSorted(String query, int maxDocs, String column, boolean ascending, boolean exact, boolean variants, boolean fuzzy) {
		try {
			return getDelegate().FTSearchSorted(query, maxDocs, column, ascending, exact, variants, fuzzy);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return -1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#FTSearchSorted(java.util.Vector)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public int FTSearchSorted(Vector query) {
		try {
			int result;
			java.util.Vector v = toDominoFriendly(query, this);
			result = getDelegate().FTSearchSorted(v);
			s_recycle(v);
			return result;
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return -1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#FTSearchSorted(java.util.Vector, int)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public int FTSearchSorted(Vector query, int maxDocs) {
		try {
			int result;
			java.util.Vector v = toDominoFriendly(query, this);
			result = getDelegate().FTSearchSorted(v, maxDocs);
			s_recycle(v);
			return result;
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return -1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#FTSearchSorted(java.util.Vector, int, int)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public int FTSearchSorted(Vector query, int maxDocs, int column) {
		try {
			int result;
			java.util.Vector v = toDominoFriendly(query, this);
			result = getDelegate().FTSearchSorted(v, maxDocs, column);
			s_recycle(v);
			return result;
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return -1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#FTSearchSorted(java.util.Vector, int, int, boolean, boolean, boolean, boolean)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public int FTSearchSorted(Vector query, int maxDocs, int column, boolean ascending, boolean exact, boolean variants, boolean fuzzy) {
		try {
			int result;
			java.util.Vector v = toDominoFriendly(query, this);
			result = getDelegate().FTSearchSorted(v, maxDocs, column, ascending, exact, variants, fuzzy);
			s_recycle(v);
			return result;
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return -1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#FTSearchSorted(java.util.Vector, int, java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public int FTSearchSorted(Vector query, int maxDocs, String column) {
		try {
			return getDelegate().FTSearchSorted(toDominoFriendly(query, this), maxDocs, column);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return -1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#FTSearchSorted(java.util.Vector, int, java.lang.String, boolean, boolean, boolean, boolean)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public int FTSearchSorted(Vector query, int maxDocs, String column, boolean ascending, boolean exact, boolean variants, boolean fuzzy) {
		try {
			int result;
			java.util.Vector v = toDominoFriendly(query, this);
			result = getDelegate().FTSearchSorted(toDominoFriendly(query, this), maxDocs, column, ascending, exact, variants, fuzzy);
			s_recycle(v);
			return result;
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return -1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#clear()
	 */
	@Override
	public void clear() {
		try {
			getDelegate().clear();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#copyColumn(int)
	 */
	@Override
	public ViewColumn copyColumn(int sourceColumn) {
		try {
			return Factory.fromLotus(getDelegate().copyColumn(sourceColumn), ViewColumn.class, this);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#copyColumn(int, int)
	 */
	@Override
	public ViewColumn copyColumn(int sourceColumn, int destinationIndex) {
		try {
			return Factory.fromLotus(getDelegate().copyColumn(sourceColumn, destinationIndex), ViewColumn.class, this);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#copyColumn(java.lang.String)
	 */
	@Override
	public ViewColumn copyColumn(String sourceColumn) {
		try {
			return Factory.fromLotus(getDelegate().copyColumn(sourceColumn), ViewColumn.class, this);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#copyColumn(java.lang.String, int)
	 */
	@Override
	public ViewColumn copyColumn(String sourceColumn, int destinationIndex) {
		try {
			return Factory.fromLotus(getDelegate().copyColumn(sourceColumn, destinationIndex), ViewColumn.class, this);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#copyColumn(lotus.domino.ViewColumn)
	 */
	@Override
	public ViewColumn copyColumn(lotus.domino.ViewColumn sourceColumn) {
		try {
			return Factory.fromLotus(getDelegate().copyColumn((lotus.domino.ViewColumn) toLotus(sourceColumn)), ViewColumn.class, this);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#copyColumn(lotus.domino.ViewColumn, int)
	 */
	@Override
	public ViewColumn copyColumn(lotus.domino.ViewColumn sourceColumn, int destinationIndex) {
		try {
			return Factory.fromLotus(getDelegate().copyColumn((lotus.domino.ViewColumn) toLotus(sourceColumn), destinationIndex),
					ViewColumn.class, this);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#createColumn()
	 */
	@Override
	public ViewColumn createColumn() {
		try {
			return Factory.fromLotus(getDelegate().createColumn(), ViewColumn.class, this);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#createColumn(int)
	 */
	@Override
	public ViewColumn createColumn(int position) {
		try {
			return Factory.fromLotus(getDelegate().createColumn(position), ViewColumn.class, this);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#createColumn(int, java.lang.String)
	 */
	@Override
	public ViewColumn createColumn(int position, String columnTitle) {
		try {
			return Factory.fromLotus(getDelegate().createColumn(position, columnTitle), ViewColumn.class, this);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#createColumn(int, java.lang.String, java.lang.String)
	 */
	@Override
	public ViewColumn createColumn(int position, String columnTitle, String formula) {
		try {
			return Factory.fromLotus(getDelegate().createColumn(position, columnTitle, formula), ViewColumn.class, this);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#createViewEntryCollection()
	 */
	@Override
	public ViewEntryCollection createViewEntryCollection() {
		try {
			return Factory.fromLotus(getDelegate().createViewEntryCollection(), ViewEntryCollection.class, this);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#createViewNav()
	 */
	@Override
	public ViewNavigator createViewNav() {
		try {
			return Factory.fromLotus(getDelegate().createViewNav(), ViewNavigator.class, this);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#createViewNav(int)
	 */
	@Override
	public ViewNavigator createViewNav(int cacheSize) {
		try {
			return Factory.fromLotus(getDelegate().createViewNav(cacheSize), ViewNavigator.class, this);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#createViewNavFrom(java.lang.Object)
	 */
	@Override
	public ViewNavigator createViewNavFrom(Object entry) {
		try {
			return Factory.fromLotus(getDelegate().createViewNavFrom(toLotus(entry)), ViewNavigator.class, this);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#createViewNavFrom(java.lang.Object, int)
	 */
	@Override
	public ViewNavigator createViewNavFrom(Object entry, int cacheSize) {
		try {
			return Factory.fromLotus(getDelegate().createViewNavFrom(toLotus(entry), cacheSize), ViewNavigator.class, this);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#createViewNavFromAllUnread()
	 */
	@Override
	public ViewNavigator createViewNavFromAllUnread() {
		try {
			return Factory.fromLotus(getDelegate().createViewNavFromAllUnread(), ViewNavigator.class, this);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#createViewNavFromAllUnread(java.lang.String)
	 */
	@Override
	public ViewNavigator createViewNavFromAllUnread(String userName) {
		try {
			return Factory.fromLotus(getDelegate().createViewNavFromAllUnread(userName), ViewNavigator.class, this);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#createViewNavFromCategory(java.lang.String)
	 */
	@Override
	public ViewNavigator createViewNavFromCategory(String categoryName) {
		try {
			return Factory.fromLotus(getDelegate().createViewNavFromCategory(categoryName), ViewNavigator.class, this);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#createViewNavFromCategory(java.lang.String, int)
	 */
	@Override
	public ViewNavigator createViewNavFromCategory(String categoryName, int cacheSize) {
		try {
			return Factory.fromLotus(getDelegate().createViewNavFromCategory(categoryName, cacheSize), ViewNavigator.class, this);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#createViewNavFromChildren(java.lang.Object)
	 */
	@Override
	public ViewNavigator createViewNavFromChildren(Object entry) {
		try {
			return Factory.fromLotus(getDelegate().createViewNavFromChildren(toLotus(entry)), ViewNavigator.class, this);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#createViewNavFromChildren(java.lang.Object, int)
	 */
	@Override
	public ViewNavigator createViewNavFromChildren(Object entry, int cacheSize) {
		try {
			return Factory.fromLotus(getDelegate().createViewNavFromChildren(toLotus(entry), cacheSize), ViewNavigator.class, this);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#createViewNavFromDescendants(java.lang.Object)
	 */
	@Override
	public ViewNavigator createViewNavFromDescendants(Object entry) {
		try {
			return Factory.fromLotus(getDelegate().createViewNavFromDescendants(toLotus(entry)), ViewNavigator.class, this);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#createViewNavFromDescendants(java.lang.Object, int)
	 */
	@Override
	public ViewNavigator createViewNavFromDescendants(Object entry, int cacheSize) {
		try {
			return Factory.fromLotus(getDelegate().createViewNavFromDescendants(toLotus(entry), cacheSize), ViewNavigator.class, this);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#createViewNavMaxLevel(int)
	 */
	@Override
	public ViewNavigator createViewNavMaxLevel(int level) {
		try {
			return Factory.fromLotus(getDelegate().createViewNavMaxLevel(level), ViewNavigator.class, this);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#createViewNavMaxLevel(int, int)
	 */
	@Override
	public ViewNavigator createViewNavMaxLevel(int level, int cacheSize) {
		try {
			return Factory.fromLotus(getDelegate().createViewNavMaxLevel(level, cacheSize), ViewNavigator.class, this);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#getAliases()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Vector<String> getAliases() {
		try {
			return (Vector<String>) getDelegate().getAliases();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.ext.View#getAllDocuments()
	 */
	public DocumentCollection getAllDocuments() {
		// FIXME - NTF Make efficient
		DocumentCollection result = this.getParent().createDocumentCollection();
		for (org.openntf.domino.ViewEntry entry : this.getAllEntries()) {
			if (entry.isDocument()) {
				result.addDocument(entry.getDocument()); // FIX for JG's admittedly "crappy implementation."
			}
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#getAllDocumentsByKey(java.lang.Object)
	 */
	@Override
	public DocumentCollection getAllDocumentsByKey(Object key) {
		try {
			return Factory.fromLotus(getDelegate().getAllDocumentsByKey(toLotus(key)), DocumentCollection.class, this);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#getAllDocumentsByKey(java.lang.Object, boolean)
	 */
	@Override
	public DocumentCollection getAllDocumentsByKey(Object key, boolean exact) {
		try {
			return Factory.fromLotus(getDelegate().getAllDocumentsByKey(toLotus(key), exact), DocumentCollection.class, this);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#getAllDocumentsByKey(java.util.Vector)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public DocumentCollection getAllDocumentsByKey(Vector keys) {
		try {
			return Factory.fromLotus(getDelegate().getAllDocumentsByKey(toLotus(keys)), DocumentCollection.class, this);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#getAllDocumentsByKey(java.util.Vector, boolean)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public DocumentCollection getAllDocumentsByKey(Vector keys, boolean exact) {
		try {
			return Factory.fromLotus(getDelegate().getAllDocumentsByKey(toLotus(keys), exact), DocumentCollection.class, this);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#getAllEntries()
	 */
	@Override
	public ViewEntryCollection getAllEntries() {
		try {
			return Factory.fromLotus(getDelegate().getAllEntries(), ViewEntryCollection.class, this);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#getAllEntriesByKey(java.lang.Object)
	 */
	@Override
	public ViewEntryCollection getAllEntriesByKey(Object key) {
		try {
			return Factory.fromLotus(getDelegate().getAllEntriesByKey(toLotus(key)), ViewEntryCollection.class, this);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#getAllEntriesByKey(java.lang.Object, boolean)
	 */
	@Override
	public ViewEntryCollection getAllEntriesByKey(Object key, boolean exact) {
		try {
			return Factory.fromLotus(getDelegate().getAllEntriesByKey(toLotus(key), exact), ViewEntryCollection.class, this);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#getAllEntriesByKey(java.util.Vector)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public ViewEntryCollection getAllEntriesByKey(Vector keys) {
		try {
			return Factory.fromLotus(getDelegate().getAllEntriesByKey(toLotus(keys)), ViewEntryCollection.class, this);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#getAllEntriesByKey(java.util.Vector, boolean)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public ViewEntryCollection getAllEntriesByKey(Vector keys, boolean exact) {
		try {
			return Factory.fromLotus(getDelegate().getAllEntriesByKey(toLotus(keys), exact), ViewEntryCollection.class, this);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#getAllReadEntries()
	 */
	@Override
	public ViewEntryCollection getAllReadEntries() {
		try {
			return Factory.fromLotus(getDelegate().getAllReadEntries(), ViewEntryCollection.class, this);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#getAllReadEntries(java.lang.String)
	 */
	@Override
	public ViewEntryCollection getAllReadEntries(String userName) {
		try {
			return Factory.fromLotus(getDelegate().getAllReadEntries(userName), ViewEntryCollection.class, this);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#getAllUnreadEntries()
	 */
	@Override
	public ViewEntryCollection getAllUnreadEntries() {
		try {
			return Factory.fromLotus(getDelegate().getAllUnreadEntries(), ViewEntryCollection.class, this);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#getAllUnreadEntries(java.lang.String)
	 */
	@Override
	public ViewEntryCollection getAllUnreadEntries(String userName) {
		try {
			return Factory.fromLotus(getDelegate().getAllUnreadEntries(userName), ViewEntryCollection.class, this);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#getBackgroundColor()
	 */
	@Override
	public int getBackgroundColor() {
		try {
			return getDelegate().getBackgroundColor();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#getChild(lotus.domino.Document)
	 */
	@Override
	public Document getChild(lotus.domino.Document doc) {
		try {
			return Factory.fromLotus(getDelegate().getChild((lotus.domino.Document) toLotus(doc)), Document.class, this);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#getColumn(int)
	 */
	@Override
	public ViewColumn getColumn(int columnNumber) {
		try {
			return Factory.fromLotus(getDelegate().getColumn(columnNumber), ViewColumn.class, this);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#getColumnCount()
	 */
	@Override
	public int getColumnCount() {
		try {
			return getDelegate().getColumnCount();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return -1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#getColumnNames()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Vector<String> getColumnNames() {
		try {
			return (Vector<String>) getDelegate().getColumnNames();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#getColumnValues(int)
	 */
	@Override
	public Vector<Object> getColumnValues(int column) {
		try {
			return Factory.wrapColumnValues(getDelegate().getColumnValues(column), this.getAncestorSession());
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#getColumns()
	 */
	@Override
	public Vector<org.openntf.domino.ViewColumn> getColumns() {
		try {
			return Factory.fromLotusAsVector(getDelegate().getColumns(), org.openntf.domino.ViewColumn.class, this);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#getCreated()
	 */
	@Override
	public DateTime getCreated() {
		try {
			return Factory.fromLotus(getDelegate().getCreated(), DateTime.class, this);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#getDocumentByKey(java.lang.Object)
	 */
	@Override
	public Document getDocumentByKey(Object key) {
		try {
			return Factory.fromLotus(getDelegate().getDocumentByKey(toLotus(key)), Document.class, this);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#getDocumentByKey(java.lang.Object, boolean)
	 */
	@Override
	public Document getDocumentByKey(Object key, boolean exact) {
		try {
			return Factory.fromLotus(getDelegate().getDocumentByKey(toLotus(key), exact), Document.class, this);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#getDocumentByKey(java.util.Vector)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Document getDocumentByKey(Vector keys) {
		try {
			return Factory.fromLotus(getDelegate().getDocumentByKey(toLotus(keys)), Document.class, this);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#getDocumentByKey(java.util.Vector, boolean)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Document getDocumentByKey(Vector keys, boolean exact) {
		try {
			return Factory.fromLotus(getDelegate().getDocumentByKey(toLotus(keys), exact), Document.class, this);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#getEntryByKey(java.lang.Object)
	 */
	@Override
	public ViewEntry getEntryByKey(Object key) {
		try {
			return Factory.fromLotus(getDelegate().getEntryByKey(toLotus(key)), ViewEntry.class, this);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#getEntryByKey(java.lang.Object, boolean)
	 */
	@Override
	public ViewEntry getEntryByKey(Object key, boolean exact) {
		try {
			return Factory.fromLotus(getDelegate().getEntryByKey(toLotus(key), exact), ViewEntry.class, this);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#getEntryByKey(java.util.Vector)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public ViewEntry getEntryByKey(Vector keys) {
		try {
			return Factory.fromLotus(getDelegate().getEntryByKey(toLotus(keys)), ViewEntry.class, this);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#getEntryByKey(java.util.Vector, boolean)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public ViewEntry getEntryByKey(Vector keys, boolean exact) {
		try {
			return Factory.fromLotus(getDelegate().getEntryByKey(toLotus(keys), exact), ViewEntry.class, this);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#getEntryCount()
	 */
	@Override
	public int getEntryCount() {
		try {
			return getDelegate().getEntryCount();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return -1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#getFirstDocument()
	 */
	@Override
	public Document getFirstDocument() {
		try {
			return Factory.fromLotus(getDelegate().getFirstDocument(), Document.class, this);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#getHeaderLines()
	 */
	@Override
	public int getHeaderLines() {
		try {
			return getDelegate().getHeaderLines();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return -1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#getHttpURL()
	 */
	@Override
	public String getHttpURL() {
		try {
			return getDelegate().getHttpURL();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#getLastDocument()
	 */
	@Override
	public Document getLastDocument() {
		try {
			return Factory.fromLotus(getDelegate().getLastDocument(), Document.class, this);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#getLastModified()
	 */
	@Override
	public DateTime getLastModified() {
		try {
			return Factory.fromLotus(getDelegate().getLastModified(), DateTime.class, this);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#getLockHolders()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Vector<String> getLockHolders() {
		try {
			return (Vector<String>) getDelegate().getLockHolders();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#getName()
	 */
	@Override
	public String getName() {
		try {
			return getDelegate().getName();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#getNextDocument(lotus.domino.Document)
	 */
	@Override
	public Document getNextDocument(lotus.domino.Document doc) {
		try {
			return Factory.fromLotus(getDelegate().getNextDocument((lotus.domino.Document) toLotus(doc)), Document.class, this);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#getNextSibling(lotus.domino.Document)
	 */
	@Override
	public Document getNextSibling(lotus.domino.Document doc) {
		try {
			return Factory.fromLotus(getDelegate().getNextSibling((lotus.domino.Document) toLotus(doc)), Document.class, this);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see org.openntf.domino.types.Design#getNoteID()
	 */
	@Override
	public String getNoteID() {
		NoteCollection notes = this.getParent().createNoteCollection(false);
		notes.add(this);
		return notes.getFirstNoteID();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#getNotesURL()
	 */
	@Override
	public String getNotesURL() {
		try {
			return getDelegate().getNotesURL();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#getNthDocument(int)
	 */
	@Override
	public Document getNthDocument(int n) {
		try {
			return Factory.fromLotus(getDelegate().getNthDocument(n), Document.class, this);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.impl.Base#getParent()
	 */
	@Override
	public Database getParent() {
		return (Database) super.getParent();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#getParentDocument(lotus.domino.Document)
	 */
	@Override
	public Document getParentDocument(lotus.domino.Document doc) {
		try {
			return Factory.fromLotus(getDelegate().getParentDocument((lotus.domino.Document) toLotus(doc)), Document.class, this);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#getPrevDocument(lotus.domino.Document)
	 */
	@Override
	public Document getPrevDocument(lotus.domino.Document doc) {
		try {
			return Factory.fromLotus(getDelegate().getPrevDocument((lotus.domino.Document) toLotus(doc)), Document.class, this);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#getPrevSibling(lotus.domino.Document)
	 */
	@Override
	public Document getPrevSibling(lotus.domino.Document doc) {
		try {
			return Factory.fromLotus(getDelegate().getPrevSibling((lotus.domino.Document) toLotus(doc)), Document.class, this);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#getReaders()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Vector<String> getReaders() {
		try {
			return (Vector<String>) getDelegate().getReaders();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#getRowLines()
	 */
	@Override
	public int getRowLines() {
		try {
			return getDelegate().getRowLines();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return -1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#getSelectionFormula()
	 */
	@Override
	public String getSelectionFormula() {
		try {
			return getDelegate().getSelectionFormula();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#getSelectionQuery()
	 */
	@Override
	public String getSelectionQuery() {
		try {
			return getDelegate().getSelectionQuery();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#getSpacing()
	 */
	@Override
	public int getSpacing() {
		try {
			return getDelegate().getSpacing();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return -1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#getTopLevelEntryCount()
	 */
	@Override
	public int getTopLevelEntryCount() {
		try {
			return getDelegate().getTopLevelEntryCount();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return -1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#getURL()
	 */
	@Override
	public String getURL() {
		try {
			return getDelegate().getURL();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#getUniversalID()
	 */
	@Override
	public String getUniversalID() {
		try {
			return getDelegate().getUniversalID();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#getViewInheritedName()
	 */
	@Override
	public String getViewInheritedName() {
		try {
			return getDelegate().getViewInheritedName();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#isAutoUpdate()
	 */
	@Override
	public boolean isAutoUpdate() {
		try {
			return getDelegate().isAutoUpdate();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#isCalendar()
	 */
	@Override
	public boolean isCalendar() {
		try {
			return getDelegate().isCalendar();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#isCategorized()
	 */
	@Override
	public boolean isCategorized() {
		try {
			return getDelegate().isCategorized();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#isConflict()
	 */
	@Override
	public boolean isConflict() {
		try {
			return getDelegate().isConflict();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#isDefaultView()
	 */
	@Override
	public boolean isDefaultView() {
		try {
			return getDelegate().isDefaultView();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#isEnableNoteIDsForCategories()
	 */
	@Override
	public boolean isEnableNoteIDsForCategories() {
		try {
			return getDelegate().isEnableNoteIDsForCategories();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#isFolder()
	 */
	@Override
	public boolean isFolder() {
		try {
			return getDelegate().isFolder();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#isHierarchical()
	 */
	@Override
	public boolean isHierarchical() {
		try {
			return getDelegate().isHierarchical();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#isModified()
	 */
	@Override
	public boolean isModified() {
		try {
			return getDelegate().isModified();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#isPrivate()
	 */
	@Override
	public boolean isPrivate() {
		try {
			return getDelegate().isPrivate();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#isProhibitDesignRefresh()
	 */
	@Override
	public boolean isProhibitDesignRefresh() {
		try {
			return getDelegate().isProhibitDesignRefresh();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#isProtectReaders()
	 */
	@Override
	public boolean isProtectReaders() {
		try {
			return getDelegate().isProtectReaders();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#isQueryView()
	 */
	@Override
	public boolean isQueryView() {
		try {
			return getDelegate().isQueryView();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#lock()
	 */
	@Override
	public boolean lock() {
		try {
			return getDelegate().lock();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#lock(boolean)
	 */
	@Override
	public boolean lock(boolean provisionalOk) {
		try {
			return getDelegate().lock(provisionalOk);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#lock(java.lang.String)
	 */
	@Override
	public boolean lock(String name) {
		try {
			return getDelegate().lock(name);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#lock(java.lang.String, boolean)
	 */
	@Override
	public boolean lock(String name, boolean provisionalOk) {
		try {
			return getDelegate().lock(name, provisionalOk);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#lock(java.util.Vector)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean lock(Vector names) {
		try {
			return getDelegate().lock(names);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#lock(java.util.Vector, boolean)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean lock(Vector names, boolean provisionalOk) {
		try {
			return getDelegate().lock(names, provisionalOk);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#lockProvisional()
	 */
	@Override
	public boolean lockProvisional() {
		try {
			return getDelegate().lockProvisional();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#lockProvisional(java.lang.String)
	 */
	@Override
	public boolean lockProvisional(String name) {
		try {
			return getDelegate().lockProvisional(name);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#lockProvisional(java.util.Vector)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean lockProvisional(Vector names) {
		try {
			return getDelegate().lockProvisional(names);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#markAllRead()
	 */
	@Override
	public void markAllRead() {
		try {
			getDelegate().markAllRead();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#markAllRead(java.lang.String)
	 */
	@Override
	public void markAllRead(String userName) {
		try {
			getDelegate().markAllRead(userName);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#markAllUnread()
	 */
	@Override
	public void markAllUnread() {
		try {
			getDelegate().markAllUnread();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#markAllUnread(java.lang.String)
	 */
	@Override
	public void markAllUnread(String userName) {
		try {
			getDelegate().markAllUnread(userName);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#refresh()
	 */
	@Override
	public void refresh() {
		try {
			getDelegate().refresh();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#remove()
	 */
	@Override
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
	 * @see org.openntf.domino.View#removeColumn()
	 */
	@Override
	public void removeColumn() {
		try {
			getDelegate().removeColumn();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#removeColumn(int)
	 */
	@Override
	public void removeColumn(int column) {
		try {
			getDelegate().removeColumn(column);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#removeColumn(java.lang.String)
	 */
	@Override
	public void removeColumn(String column) {
		try {
			getDelegate().removeColumn(column);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#resortView()
	 */
	@Override
	public void resortView() {
		try {
			getDelegate().resortView();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#resortView(java.lang.String)
	 */
	@Override
	public void resortView(String column) {
		try {
			getDelegate().resortView(column);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#resortView(java.lang.String, boolean)
	 */
	@Override
	public void resortView(String column, boolean ascending) {
		try {
			getDelegate().resortView(column, ascending);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#setAliases(java.lang.String)
	 */
	@Override
	public void setAliases(String alias) {
		try {
			getDelegate().setAliases(alias);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#setAliases(java.util.Vector)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void setAliases(Vector aliases) {
		try {
			getDelegate().setAliases(aliases);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#setAutoUpdate(boolean)
	 */
	@Override
	public void setAutoUpdate(boolean flag) {
		try {
			getDelegate().setAutoUpdate(flag);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#setBackgroundColor(int)
	 */
	@Override
	public void setBackgroundColor(int color) {
		try {
			getDelegate().setBackgroundColor(color);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#setDefaultView(boolean)
	 */
	@Override
	public void setDefaultView(boolean flag) {
		try {
			getDelegate().setDefaultView(flag);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#setEnableNoteIDsForCategories(boolean)
	 */
	@Override
	public void setEnableNoteIDsForCategories(boolean flag) {
		try {
			getDelegate().setEnableNoteIDsForCategories(flag);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#setName(java.lang.String)
	 */
	@Override
	public void setName(String name) {
		try {
			getDelegate().setName(name);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#setProhibitDesignRefresh(boolean)
	 */
	@Override
	public void setProhibitDesignRefresh(boolean flag) {
		try {
			getDelegate().setProhibitDesignRefresh(flag);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#setProtectReaders(boolean)
	 */
	@Override
	public void setProtectReaders(boolean flag) {
		try {
			getDelegate().setProtectReaders(flag);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#setReaders(java.util.Vector)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void setReaders(Vector readers) {
		try {
			getDelegate().setReaders(readers);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#setSelectionFormula(java.lang.String)
	 */
	@Override
	public void setSelectionFormula(String formula) {
		try {
			getDelegate().setSelectionFormula(formula);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#setSelectionQuery(java.lang.String)
	 */
	@Override
	public void setSelectionQuery(String query) {
		try {
			getDelegate().setSelectionQuery(query);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#setSpacing(int)
	 */
	@Override
	public void setSpacing(int spacing) {
		try {
			getDelegate().setSpacing(spacing);
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#unlock()
	 */
	@Override
	public void unlock() {
		try {
			getDelegate().unlock();
		} catch (NotesException e) {
			DominoUtils.handleException(e);
		}
	}

	/*
	 * New methods
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.View#getDocument()
	 */
	@Override
	public Document getDocument() {
		Database parent = this.getParent();
		return parent.getDocumentByUNID(this.getUniversalID());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.openntf.domino.types.DatabaseDescendant#getAncestorDatabase()
	 */
	@Override
	public Database getAncestorDatabase() {
		return this.getParent();
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
}
