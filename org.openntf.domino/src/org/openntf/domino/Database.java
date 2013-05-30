/*
 * Copyright 2013
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
package org.openntf.domino;

import java.util.Map;
import java.util.Vector;

import org.openntf.domino.annotations.Legacy;
import org.openntf.domino.types.Resurrectable;
import org.openntf.domino.types.SessionDescendant;

/**
 * The Interface Database.
 */
public interface Database extends lotus.domino.Database, org.openntf.domino.Base<lotus.domino.Database>, org.openntf.domino.ext.Database,
		Map<String, Document>, Resurrectable, SessionDescendant {

	/**
	 * The Enum DBOption.
	 */
	public static enum DBOption {
		LZ1(Database.DBOPT_LZ1), LZCOMPRESSION(Database.DBOPT_LZCOMPRESSION), MAINTAINLASTACCESSED(Database.DBOPT_MAINTAINLASTACCESSED), MOREFIELDS(
				Database.DBOPT_MOREFIELDS), NOHEADLINEMONITORS(Database.DBOPT_NOHEADLINEMONITORS), NOOVERWRITE(Database.DBOPT_NOOVERWRITE), NORESPONSEINFO(
				Database.DBOPT_NORESPONSEINFO), NOTRANSACTIONLOGGING(Database.DBOPT_NOTRANSACTIONLOGGING), NOUNREAD(Database.DBOPT_NOUNREAD), OPTIMIZAION(
				Database.DBOPT_OPTIMIZATION), REPLICATEUNREADMARKSTOANY(Database.DBOPT_REPLICATEUNREADMARKSTOANY), REPLICATEUNREADMARKSTOCLUSTER(
				Database.DBOPT_REPLICATEUNREADMARKSTOCLUSTER), REPLICATEUNREADMARKSNEVER(Database.DBOPT_REPLICATEUNREADMARKSNEVER), SOFTDELETE(
				Database.DBOPT_SOFTDELETE), COMPRESSDESIGN(Database.DBOPT_COMPRESSDESIGN), COMPRESSDOCUMENTS(
				Database.DBOPT_COMPRESSDOCUMENTS), OUTOFOFFICEENABLED(Database.DBOPT_OUTOFOFFICEENABLED), NOSIMPLESEARCH(
				Database.DBOPT_NOSIMPLESEARCH), USEDAOS(Database.DBOPT_USEDAOS);

		/** The value_. */
		private final int value_;

		/**
		 * Instantiates a new dB option.
		 * 
		 * @param value
		 *            the value
		 */
		private DBOption(int value) {
			value_ = value;
		}

		/**
		 * Gets the value.
		 * 
		 * @return the value
		 */
		public int getValue() {
			return value_;
		}

		public static DBOption valueOf(int value) {
			for (DBOption opt : values()) {
				if (opt.getValue() == value) {
					return opt;
				}
			}
			return null;
		}
	}

	/**
	 * The Enum SignDocType.
	 */
	public static enum SignDocType {

		/** The acl. */
		ACL(Database.DBSIGN_DOC_ACL),
		/** The agent. */
		AGENT(Database.DBSIGN_DOC_AGENT),
		/** The all. */
		ALL(Database.DBSIGN_DOC_ALL),
		/** The data. */
		DATA(Database.DBSIGN_DOC_DATA),
		/** The form. */
		FORM(Database.DBSIGN_DOC_FORM),
		/** The help. */
		HELP(Database.DBSIGN_DOC_HELP),
		/** The icon. */
		ICON(Database.DBSIGN_DOC_ICON),
		/** The replformula. */
		REPLFORMULA(Database.DBSIGN_DOC_REPLFORMULA),
		/** The sharedfield. */
		SHAREDFIELD(Database.DBSIGN_DOC_SHAREDFIELD),
		/** The view. */
		VIEW(Database.DBSIGN_DOC_VIEW);

		/** The value_. */
		private final int value_;

		/**
		 * Instantiates a new sign doc type.
		 * 
		 * @param value
		 *            the value
		 */
		private SignDocType(int value) {
			value_ = value;
		}

		/**
		 * Gets the value.
		 * 
		 * @return the value
		 */
		public int getValue() {
			return value_;
		}

		public static SignDocType valueOf(int value) {
			for (SignDocType opt : values()) {
				if (opt.getValue() == value) {
					return opt;
				}
			}
			return null;
		}
	}

	public static enum CompactOption {
		ARCHIVE_DELETE_COMPACT(Database.CMPC_ARCHIVE_DELETE_COMPACT), ARCHIVE_DELETE_ONLY(Database.CMPC_ARCHIVE_DELETE_ONLY), CHK_OVERLAP(
				Database.CMPC_CHK_OVERLAP), COPYSTYLE(Database.CMPC_COPYSTYLE), DISABLE_DOCTBLBIT_OPTMZN(
				Database.CMPC_DISABLE_DOCTBLBIT_OPTMZN), DISABLE_LARGE_UNKTBL(Database.CMPC_DISABLE_LARGE_UNKTBL), DISABLE_RESPONSE_INFO(
				Database.CMPC_DISABLE_RESPONSE_INFO), DISABLE_TRANSACTIONLOGGING(Database.CMPC_DISABLE_TRANSACTIONLOGGING), DISABLE_UNREAD_MARKS(
				Database.CMPC_DISABLE_UNREAD_MARKS), DISCARD_VIEW_INDICIES(Database.CMPC_DISCARD_VIEW_INDICES), ENABLE_DOCTBLBIT_OPTMZN(
				Database.CMPC_ENABLE_DOCTBLBIT_OPTMZN), ENABLE_LARGE_UNKTBL(Database.CMPC_ENABLE_LARGE_UNKTBL), ENABLE_RESPONSE_INFO(
				Database.CMPC_ENABLE_RESPONSE_INFO), ENABLE_TRANSACTIONLOGGING(Database.CMPC_ENABLE_TRANSACTIONLOGGING), ENABLE_UNREAD_MARKS(
				Database.CMPC_ENABLE_UNREAD_MARKS), IGNORE_COPYSTYLE_ERRORS(Database.CMPC_IGNORE_COPYSTYLE_ERRORS), MAX_4GB(
				Database.CMPC_MAX_4GB), NO_LOCKOUT(Database.CMPC_NO_LOCKOUT), RECOVER_INPLACE(Database.CMPC_RECOVER_INPLACE), RECOVER_REDUCE_INPLACE(
				Database.CMPC_RECOVER_REDUCE_INPLACE), REVERT_FILEFORMAT(Database.CMPC_REVERT_FILEFORMAT);

		private final int value_;

		private CompactOption(int value) {
			value_ = value;
		}

		public int getValue() {
			return value_;
		}

		public static CompactOption valueOf(int value) {
			for (CompactOption opt : values()) {
				if (opt.getValue() == value) {
					return opt;
				}
			}
			return null;
		}
	}

	public static enum FTIndexOption {
		ALL_BREAKS(Database.FTINDEX_ALL_BREAKS), ATTACHED_BIN_FILES(Database.FTINDEX_ATTACHED_BIN_FILES), ATTACHED_FILES(
				Database.FTINDEX_ATTACHED_FILES), CASE_SENSITIVE(Database.FTINDEX_CASE_SENSITIVE), ENCRYPTED_FIELDS(
				Database.FTINDEX_ENCRYPTED_FIELDS);

		private final int value_;

		private FTIndexOption(int value) {
			value_ = value;
		}

		public int getValue() {
			return value_;
		}

		public static FTIndexOption valueOf(int value) {
			for (FTIndexOption opt : values()) {
				if (opt.getValue() == value) {
					return opt;
				}
			}
			return null;
		}
	}

	public static enum FixupOption {
		INCREMENTAL(Database.FIXUP_INCREMENTAL), NODELETE(Database.FIXUP_NODELETE), NOVIEWS(Database.FIXUP_NOVIEWS), QUICK(
				Database.FIXUP_QUICK), REVERT(Database.FIXUP_REVERT), TXLOGGED(Database.FIXUP_TXLOGGED), VERIFY(Database.FIXUP_VERIFY);

		private final int value_;

		private FixupOption(int value) {
			value_ = value;
		}

		public int getValue() {
			return value_;
		}

		public static FixupOption valueOf(int value) {
			for (FixupOption opt : values()) {
				if (opt.getValue() == value) {
					return opt;
				}
			}
			return null;
		}
	}

	public static enum FTIndexFrequency {
		DAILY(Database.FTINDEX_DAILY), HOURLY(Database.FTINDEX_HOURLY), IMMEDIATE(Database.FTINDEX_IMMEDIATE), SCHEDULED(
				Database.FTINDEX_SCHEDULED);

		private final int value_;

		private FTIndexFrequency(int value) {
			value_ = value;
		}

		public int getValue() {
			return value_;
		}

		public static FTIndexFrequency valueOf(int value) {
			for (FTIndexFrequency opt : values()) {
				if (opt.getValue() == value) {
					return opt;
				}
			}
			return null;
		}
	}

	public static enum FTDomainSortOption {
		SCORES(Database.FT_SCORES), DATE_DES(Database.FT_DATE_DES), DATE_ASC(Database.FT_DATE_ASC);

		private final int value_;

		private FTDomainSortOption(int value) {
			value_ = value;
		}

		public int getValue() {
			return value_;
		}

		public static FTDomainSortOption valueOf(int value) {
			for (FTDomainSortOption opt : values()) {
				if (opt.getValue() == value) {
					return opt;
				}
			}
			return null;
		}
	}

	public static enum FTDomainSearchOption {
		DATABASE(Database.FT_DATABASE), FILESYSTEM(Database.FT_FILESYSTEM), FUZZY(Database.FT_FUZZY), STEMS(Database.FT_STEMS);

		private final int value_;

		private FTDomainSearchOption(int value) {
			value_ = value;
		}

		public int getValue() {
			return value_;
		}

		public static FTDomainSearchOption valueOf(int value) {
			for (FTDomainSearchOption opt : values()) {
				if (opt.getValue() == value) {
					return opt;
				}
			}
			return null;
		}
	}

	public static enum FTSortOption {
		SCORES(Database.FT_SCORES), DATE_DES(Database.FT_DATE_DES), DATE_ASC(Database.FT_DATE_ASC), DATECREATED_DES(
				Database.FT_DATECREATED_DES), DATECREATED_ASC(Database.FT_DATECREATED_ASC);

		private final int value_;

		private FTSortOption(int value) {
			value_ = value;
		}

		public int getValue() {
			return value_;
		}

		public static FTSortOption valueOf(int value) {
			for (FTSortOption opt : values()) {
				if (opt.getValue() == value) {
					return opt;
				}
			}
			return null;
		}
	}

	public static enum FTSearchOption {
		FUZZY(Database.FT_FUZZY), STEMS(Database.FT_STEMS);

		private final int value_;

		private FTSearchOption(int value) {
			value_ = value;
		}

		public int getValue() {
			return value_;
		}

		public static FTSearchOption valueOf(int value) {
			for (FTSearchOption opt : values()) {
				if (opt.getValue() == value) {
					return opt;
				}
			}
			return null;
		}
	}

	public static enum ModifiedDocClass {
		ACL(Database.DBMOD_DOC_ACL), AGENT(Database.DBMOD_DOC_AGENT), ALL(Database.DBMOD_DOC_ALL), DATA(Database.DBMOD_DOC_DATA), FORM(
				Database.DBMOD_DOC_FORM), HELP(Database.DBMOD_DOC_HELP), ICON(Database.DBMOD_DOC_ICON), REPLFORMULA(
				Database.DBMOD_DOC_REPLFORMULA), SHAREDFIELD(Database.DBMOD_DOC_SHAREDFIELD), VIEW(Database.DBMOD_DOC_VIEW);

		private final int value_;

		private ModifiedDocClass(int value) {
			value_ = value;
		}

		public int getValue() {
			return value_;
		}

		public static ModifiedDocClass valueOf(int value) {
			for (ModifiedDocClass opt : values()) {
				if (opt.getValue() == value) {
					return opt;
				}
			}
			return null;
		}
	}

	public static enum Type {
		ADDR_BOOK(Database.DBTYPE_ADDR_BOOK), IMAP_SVR_PROXY(Database.DBTYPE_IMAP_SVR_PROXY), LIBRARY(Database.DBTYPE_LIBRARY), LIGHT_ADDR_BOOK(
				Database.DBTYPE_LIGHT_ADDR_BOOK), MAILBOX(Database.DBTYPE_MAILBOX), MAILFILE(Database.DBTYPE_MAILFILE), MULTIDB_SRCH(
				Database.DBTYPE_MULTIDB_SRCH), NEWS_SVR_PROXY(Database.DBTYPE_NEWS_SVR_PROXY), PERS_JOURNAL(Database.DBTYPE_PERS_JOURNAL), PORTFOLIO(
				Database.DBTYPE_PORTFOLIO), STANDARD(Database.DBTYPE_STANDARD), SUBSCRIPTIONS(Database.DBTYPE_SUBSCRIPTIONS), WEB_APP(
				Database.DBTYPE_WEB_APP);

		private final int value_;

		private Type(int value) {
			value_ = value;
		}

		public int getValue() {
			return value_;
		}

		public static Type valueOf(int value) {
			for (Type opt : values()) {
				if (opt.getValue() == value) {
					return opt;
				}
			}
			return null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getACLActivityLog()
	 */
	@Override
	@Deprecated
	@Legacy(Legacy.INTERFACES_WARNING)
	public Vector<String> getACLActivityLog();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#compact()
	 */
	@Override
	public int compact();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#compactWithOptions(int)
	 */
	@Override
	@Deprecated
	public int compactWithOptions(int options);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#compactWithOptions(int, java.lang.String)
	 */
	@Override
	@Deprecated
	public int compactWithOptions(int options, String spaceThreshold);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#compactWithOptions(java.lang.String)
	 */
	@Override
	public int compactWithOptions(String options);

	/*
	 * (non-Javadoc)
	 * 
	 * 
	 * <<<<<<< HEAD =======
	 * 
	 * @see java.util.Map#containsKey(java.lang.Object)
	 */
	/**
	 * Contains key.
	 * 
	 * @param key
	 *            the key
	 * @return true, if successful
	 */
	public boolean containsKey(Object key);

	/*
	 * (non-Javadoc)
	 * 
	 * 
	 * >>>>>>> origin/declan
	 * 
	 * @see lotus.domino.Database#createCopy(java.lang.String, java.lang.String)
	 */
	@Override
	public Database createCopy(String server, String dbFile);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#createCopy(java.lang.String, java.lang.String, int)
	 */
	@Override
	public Database createCopy(String server, String dbFile, int maxSize);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#createDocument()
	 */
	@Override
	public Document createDocument();

	/**
	 * Creates the document.
	 * 
	 * @param itemValues
	 *            the item values
	 * @return the document
	 */
	public Document createDocument(Map<String, Object> itemValues);

	/**
	 * Creates the document.
	 * 
	 * @param keyValuePairs
	 *            the key value pairs
	 * @return the document
	 */
	public Document createDocument(Object... keyValuePairs);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#createDocumentCollection()
	 */
	@Override
	public DocumentCollection createDocumentCollection();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#createFromTemplate(java.lang.String, java.lang.String, boolean)
	 */
	@Override
	public Database createFromTemplate(String server, String dbFile, boolean inherit);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#createFromTemplate(java.lang.String, java.lang.String, boolean, int)
	 */
	@Override
	public Database createFromTemplate(String server, String dbFile, boolean inherit, int maxSize);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#createFTIndex(int, boolean)
	 */
	@Override
	@Deprecated
	public void createFTIndex(int options, boolean recreate);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#createNoteCollection(boolean)
	 */
	@Override
	public NoteCollection createNoteCollection(boolean selectAllFlag);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#createOutline(java.lang.String)
	 */
	@Override
	public Outline createOutline(String name);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#createOutline(java.lang.String, boolean)
	 */
	@Override
	public Outline createOutline(String name, boolean defaultOutline);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#createQueryView(java.lang.String, java.lang.String)
	 */
	@Override
	public View createQueryView(String viewName, String query);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#createQueryView(java.lang.String, java.lang.String, lotus.domino.View)
	 */
	@Override
	public View createQueryView(String viewName, String query, lotus.domino.View templateView);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#createQueryView(java.lang.String, java.lang.String, lotus.domino.View, boolean)
	 */
	@Override
	public View createQueryView(String viewName, String query, lotus.domino.View templateView, boolean prohibitDesignRefresh);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#createReplica(java.lang.String, java.lang.String)
	 */
	@Override
	public Database createReplica(String server, String dbFile);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#createView()
	 */
	@Override
	public View createView();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#createView(java.lang.String)
	 */
	@Override
	public View createView(String viewName);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#createView(java.lang.String, java.lang.String)
	 */
	@Override
	public View createView(String viewName, String selectionFormula);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#createView(java.lang.String, java.lang.String, lotus.domino.View)
	 */
	@Override
	public View createView(String viewName, String selectionFormula, lotus.domino.View templateView);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#createView(java.lang.String, java.lang.String, lotus.domino.View, boolean)
	 */
	@Override
	public View createView(String viewName, String selectionFormula, lotus.domino.View templateView, boolean prohibitDesignRefresh);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#enableFolder(java.lang.String)
	 */
	@Override
	public void enableFolder(String folder);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#fixup()
	 */
	@Override
	public void fixup();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#fixup(int)
	 */
	@Override
	@Deprecated
	public void fixup(int options);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#FTDomainSearch(java.lang.String, int, int, int, int, int, java.lang.String)
	 */
	@Override
	@Deprecated
	public Document FTDomainSearch(String query, int maxDocs, int sortOpt, int otherOpt, int start, int count, String entryForm);

	/**
	 * FT domain search.
	 * 
	 * @param query
	 *            the query
	 * @param maxDocs
	 *            the max docs
	 * @param sortOpt
	 *            the sort opt
	 * @param otherOpt
	 *            the other opt
	 * @param start
	 *            the start
	 * @param count
	 *            the count
	 * @param entryForm
	 *            the entry form
	 * @return the document
	 */
	public Document FTDomainSearch(String query, int maxDocs, FTSortOption sortOpt, int otherOpt, int start, int count, String entryForm);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#FTSearch(java.lang.String)
	 */
	@Override
	public DocumentCollection FTSearch(String query);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#FTSearch(java.lang.String, int)
	 */
	@Override
	public DocumentCollection FTSearch(String query, int maxDocs);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#FTSearch(java.lang.String, int, int, int)
	 */
	@Override
	@Deprecated
	public DocumentCollection FTSearch(String query, int maxDocs, int sortOpt, int otherOpt);

	/**
	 * FT search.
	 * 
	 * @param query
	 *            the query
	 * @param maxDocs
	 *            the max docs
	 * @param sortOpt
	 *            the sort opt
	 * @param otherOpt
	 *            the other opt
	 * @return the document collection
	 */
	public DocumentCollection FTSearch(String query, int maxDocs, FTSortOption sortOpt, int otherOpt);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#FTSearchRange(java.lang.String, int, int, int, int)
	 */
	@Override
	@Deprecated
	public DocumentCollection FTSearchRange(String query, int maxDocs, int sortOpt, int otherOpt, int start);

	/**
	 * FT search range.
	 * 
	 * @param query
	 *            the query
	 * @param maxDocs
	 *            the max docs
	 * @param sortOpt
	 *            the sort opt
	 * @param otherOpt
	 *            the other opt
	 * @param start
	 *            the start
	 * @return the document collection
	 */
	public DocumentCollection FTSearchRange(String query, int maxDocs, FTSortOption sortOpt, int otherOpt, int start);

	/*
	 * (non-Javadoc)
	 * 
	 * 
	 * @see java.util.Map#get(java.lang.Object)
	 */
	/**
	 * Gets the.
	 * 
	 * @param key
	 *            the key
	 * @return the document
	 */
	public Document get(Object key);

	/*
	 * (non-Javadoc)
	 * 
	 * 
	 * @see lotus.domino.Database#getACL()
	 */
	@Override
	public ACL getACL();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getAgent(java.lang.String)
	 */
	@Override
	public Agent getAgent(String name);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getAgents()
	 */
	@Override
	@Legacy(Legacy.INTERFACES_WARNING)
	public Vector<Agent> getAgents();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getAllDocuments()
	 */
	@Override
	public DocumentCollection getAllDocuments();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getAllReadDocuments()
	 */
	@Override
	public DocumentCollection getAllReadDocuments();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getAllReadDocuments(java.lang.String)
	 */
	@Override
	public DocumentCollection getAllReadDocuments(String userName);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getAllUnreadDocuments()
	 */
	@Override
	public DocumentCollection getAllUnreadDocuments();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getAllUnreadDocuments(java.lang.String)
	 */
	@Override
	public DocumentCollection getAllUnreadDocuments(String userName);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getCategories()
	 */
	@Override
	public String getCategories();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getCreated()
	 */
	@Override
	public DateTime getCreated();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getCurrentAccessLevel()
	 */
	@Override
	public int getCurrentAccessLevel();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getDB2Schema()
	 */
	@Override
	public String getDB2Schema();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getDesignTemplateName()
	 */
	@Override
	public String getDesignTemplateName();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getDocumentByID(java.lang.String)
	 */
	@Override
	public Document getDocumentByID(String noteid);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getDocumentByUNID(java.lang.String)
	 */
	@Override
	public Document getDocumentByUNID(String unid);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getDocumentByURL(java.lang.String, boolean)
	 */
	@Override
	public Document getDocumentByURL(String url, boolean reload);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getDocumentByURL(java.lang.String, boolean, boolean, boolean, java.lang.String, java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.String, boolean)
	 */
	@Override
	public Document getDocumentByURL(String url, boolean reload, boolean reloadIfModified, boolean urlList, String charSet, String webUser,
			String webPassword, String proxyUser, String proxyPassword, boolean returnImmediately);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getFileFormat()
	 */
	@Override
	public int getFileFormat();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getFileName()
	 */
	@Override
	public String getFileName();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getFilePath()
	 */
	@Override
	public String getFilePath();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getFolderReferencesEnabled()
	 */
	@Override
	public boolean getFolderReferencesEnabled();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getForm(java.lang.String)
	 */
	@Override
	public Form getForm(String name);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getForms()
	 */
	@Override
	@Legacy(Legacy.INTERFACES_WARNING)
	public Vector<Form> getForms();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getFTIndexFrequency()
	 */
	@Override
	public int getFTIndexFrequency();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getHttpURL()
	 */
	@Override
	public String getHttpURL();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getLastFixup()
	 */
	@Override
	public DateTime getLastFixup();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getLastFTIndexed()
	 */
	@Override
	public DateTime getLastFTIndexed();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getLastModified()
	 */
	@Override
	public DateTime getLastModified();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getLimitRevisions()
	 */
	@Override
	public double getLimitRevisions();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getLimitUpdatedBy()
	 */
	@Override
	public double getLimitUpdatedBy();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getListInDbCatalog()
	 */
	@Override
	public boolean getListInDbCatalog();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getManagers()
	 */
	@Override
	@Legacy(Legacy.INTERFACES_WARNING)
	public Vector<String> getManagers();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getMaxSize()
	 */
	@Override
	public long getMaxSize();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getModifiedDocuments()
	 */
	@Override
	public DocumentCollection getModifiedDocuments();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getModifiedDocuments(lotus.domino.DateTime)
	 */
	@Override
	public DocumentCollection getModifiedDocuments(lotus.domino.DateTime since);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getModifiedDocuments(lotus.domino.DateTime, int)
	 */
	@Override
	@Deprecated
	public DocumentCollection getModifiedDocuments(lotus.domino.DateTime since, int noteClass);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getNotesURL()
	 */
	@Override
	public String getNotesURL();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getOption(int)
	 */
	@Override
	@Deprecated
	public boolean getOption(int optionName);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getOutline(java.lang.String)
	 */
	@Override
	public Outline getOutline(String outlineName);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getParent()
	 */
	@Override
	public Session getParent();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getPercentUsed()
	 */
	@Override
	public double getPercentUsed();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getProfileDocCollection(java.lang.String)
	 */
	@Override
	public DocumentCollection getProfileDocCollection(String profileName);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getProfileDocument(java.lang.String, java.lang.String)
	 */
	@Override
	public Document getProfileDocument(String profileName, String profileKey);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getReplicaID()
	 */
	@Override
	public String getReplicaID();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getReplicationInfo()
	 */
	@Override
	public Replication getReplicationInfo();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getServer()
	 */
	@Override
	public String getServer();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getSize()
	 */
	@Override
	public double getSize();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getSizeQuota()
	 */
	@Override
	public int getSizeQuota();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getSizeWarning()
	 */
	@Override
	public long getSizeWarning();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getTemplateName()
	 */
	@Override
	public String getTemplateName();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getTitle()
	 */
	@Override
	public String getTitle();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getType()
	 */
	@Override
	public int getType();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getUndeleteExpireTime()
	 */
	@Override
	public int getUndeleteExpireTime();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getURL()
	 */
	@Override
	public String getURL();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getURLHeaderInfo(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public String getURLHeaderInfo(String url, String header, String webUser, String webPassword, String proxyUser, String proxyPassword);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getView(java.lang.String)
	 */
	@Override
	public View getView(String name);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#getViews()
	 */
	@Override
	@Legacy(Legacy.INTERFACES_WARNING)
	public Vector<View> getViews();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#grantAccess(java.lang.String, int)
	 */
	@Override
	@Deprecated
	public void grantAccess(String name, int level);

	/**
	 * Grant access.
	 * 
	 * @param name
	 *            the name
	 * @param level
	 *            the level
	 */
	public void grantAccess(String name, ACL.Level level);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#isAllowOpenSoftDeleted()
	 */
	@Override
	public boolean isAllowOpenSoftDeleted();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#isClusterReplication()
	 */
	@Override
	public boolean isClusterReplication();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#isConfigurationDirectory()
	 */
	@Override
	public boolean isConfigurationDirectory();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#isCurrentAccessPublicReader()
	 */
	@Override
	public boolean isCurrentAccessPublicReader();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#isCurrentAccessPublicWriter()
	 */
	@Override
	public boolean isCurrentAccessPublicWriter();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#isDB2()
	 */
	@Override
	@Legacy(Legacy.INTERFACES_WARNING)
	public boolean isDB2();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#isDelayUpdates()
	 */
	@Override
	public boolean isDelayUpdates();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#isDesignLockingEnabled()
	 */
	@Override
	public boolean isDesignLockingEnabled();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#isDirectoryCatalog()
	 */
	@Override
	public boolean isDirectoryCatalog();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#isDocumentLockingEnabled()
	 */
	@Override
	public boolean isDocumentLockingEnabled();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#isFTIndexed()
	 */
	@Override
	public boolean isFTIndexed();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#isInMultiDbIndexing()
	 */
	@Override
	public boolean isInMultiDbIndexing();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#isInService()
	 */
	@Override
	public boolean isInService();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#isLink()
	 */
	@Override
	public boolean isLink();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#isMultiDbSearch()
	 */
	@Override
	public boolean isMultiDbSearch();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#isOpen()
	 */
	@Override
	public boolean isOpen();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#isPendingDelete()
	 */
	@Override
	public boolean isPendingDelete();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#isPrivateAddressBook()
	 */
	@Override
	public boolean isPrivateAddressBook();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#isPublicAddressBook()
	 */
	@Override
	public boolean isPublicAddressBook();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#markForDelete()
	 */
	@Override
	public void markForDelete();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#open()
	 */
	@Override
	public boolean open();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#openByReplicaID(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean openByReplicaID(String server, String replicaId);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#openIfModified(java.lang.String, java.lang.String, lotus.domino.DateTime)
	 */
	@Override
	public boolean openIfModified(String server, String dbFile, lotus.domino.DateTime modifiedSince);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#openWithFailover(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean openWithFailover(String server, String dbFile);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#queryAccess(java.lang.String)
	 */
	@Override
	public int queryAccess(String name);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#queryAccessPrivileges(java.lang.String)
	 */
	@Override
	public int queryAccessPrivileges(String name);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#queryAccessRoles(java.lang.String)
	 */
	public Vector<String> queryAccessRoles(String name);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#remove()
	 */
	@Override
	public void remove();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#removeFTIndex()
	 */
	@Override
	public void removeFTIndex();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#replicate(java.lang.String)
	 */
	@Override
	public boolean replicate(String server);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#revokeAccess(java.lang.String)
	 */
	@Override
	public void revokeAccess(String name);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#search(java.lang.String)
	 */
	@Override
	public DocumentCollection search(String formula);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#search(java.lang.String, lotus.domino.DateTime)
	 */
	@Override
	public DocumentCollection search(String formula, lotus.domino.DateTime startDate);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#search(java.lang.String, lotus.domino.DateTime, int)
	 */
	@Override
	public DocumentCollection search(String formula, lotus.domino.DateTime startDate, int maxDocs);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#setAllowOpenSoftDeleted(boolean)
	 */
	@Override
	public void setAllowOpenSoftDeleted(boolean flag);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#setCategories(java.lang.String)
	 */
	@Override
	public void setCategories(String categories);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#setDelayUpdates(boolean)
	 */
	@Override
	public void setDelayUpdates(boolean flag);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#setDesignLockingEnabled(boolean)
	 */
	@Override
	public void setDesignLockingEnabled(boolean flag);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#setDocumentLockingEnabled(boolean)
	 */
	@Override
	public void setDocumentLockingEnabled(boolean flag);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#setFolderReferencesEnabled(boolean)
	 */
	@Override
	public void setFolderReferencesEnabled(boolean flag);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#setFTIndexFrequency(int)
	 */
	@Override
	@Deprecated
	public void setFTIndexFrequency(int frequency);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#setInMultiDbIndexing(boolean)
	 */
	@Override
	public void setInMultiDbIndexing(boolean flag);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#setInService(boolean)
	 */
	@Override
	public void setInService(boolean flag);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#setLimitRevisions(double)
	 */
	@Override
	public void setLimitRevisions(double revisions);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#setLimitUpdatedBy(double)
	 */
	@Override
	public void setLimitUpdatedBy(double updatedBys);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#setListInDbCatalog(boolean)
	 */
	@Override
	public void setListInDbCatalog(boolean flag);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#setOption(int, boolean)
	 */
	@Override
	@Deprecated
	public void setOption(int optionName, boolean flag);

	/**
	 * Sets the option.
	 * 
	 * @param optionName
	 *            the option name
	 * @param flag
	 *            the flag
	 */
	public void setOption(DBOption optionName, boolean flag);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#setSizeQuota(int)
	 */
	@Override
	public void setSizeQuota(int quota);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#setSizeWarning(int)
	 */
	@Override
	public void setSizeWarning(int warning);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#setTitle(java.lang.String)
	 */
	@Override
	public void setTitle(final String title);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#setUndeleteExpireTime(int)
	 */
	@Override
	public void setUndeleteExpireTime(int hours);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#sign()
	 */
	@Override
	public void sign();

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#sign(int)
	 */
	@Override
	public void sign(int documentType);

	/**
	 * Sign.
	 * 
	 * @param documentType
	 *            the document type
	 */
	public void sign(SignDocType documentType);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#sign(int, boolean)
	 */
	@Override
	@Deprecated
	public void sign(int documentType, boolean existingSigsOnly);

	/**
	 * Sign.
	 * 
	 * @param documentType
	 *            the document type
	 * @param existingSigsOnly
	 *            the existing sigs only
	 */
	public void sign(SignDocType documentType, boolean existingSigsOnly);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#sign(int, boolean, java.lang.String)
	 */
	@Override
	@Deprecated
	public void sign(int documentType, boolean existingSigsOnly, String name);

	/**
	 * Sign.
	 * 
	 * @param documentType
	 *            the document type
	 * @param existingSigsOnly
	 *            the existing sigs only
	 * @param name
	 *            the name
	 */
	public void sign(SignDocType documentType, boolean existingSigsOnly, String name);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#sign(int, boolean, java.lang.String, boolean)
	 */
	@Override
	@Deprecated
	public void sign(int documentType, boolean existingSigsOnly, String name, boolean nameIsNoteid);

	/**
	 * Sign.
	 * 
	 * @param documentType
	 *            the document type
	 * @param existingSigsOnly
	 *            the existing sigs only
	 * @param name
	 *            the name
	 * @param nameIsNoteid
	 *            the name is noteid
	 */
	public void sign(SignDocType documentType, boolean existingSigsOnly, String name, boolean nameIsNoteid);

	/*
	 * (non-Javadoc)
	 * 
	 * @see lotus.domino.Database#updateFTIndex(boolean)
	 */
	@Override
	public void updateFTIndex(boolean create);

}
