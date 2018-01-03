package com.util;

import java.io.File;
import java.util.Arrays;
import java.util.List;


public class AppConstants {
	/**
	 * Encryption Algorithm constants
	 */
	public static final String ALGORITHM = "AES";
	public static final byte[] KEY_VALUE = new byte[] { 'a', 'p', 'p', 't',
			'i', 'u', 'm', 'S', 'e', 'c', 'r', 'e', 't', 'K', 'e', 'y' };

	/**
	 * Authentication constants
	 */
	public static final String AUTHENTICATION_FAILURE = "INVALID_CREDENTIALS_MSG";
	public static final String AUTHENTICATION_SUCESSS = "VALID_CREDENTIALS_MSG";
	/**
	 * DB configuration constants
	 */
	public static final String DB_CLASS = "db.driver.class";
	public static final String DB_URL = "db.connection.url";
	public static final String DB_NAME = "db.constant.name";
	/**
	 * DB credentials constants
	 */
	public static final String APP_DEFAULT_USERNAME = "eportal.app.default.user";
	public static final String APP_DEFAULT_PASSWORD = "eportal.app.default.password";
	public static final String APP_ROLE_SUPER_ADMIN = "eportal.app.default.role.superadmin";
	public static final String APP_ROLE_ADMIN = "eportal.app.default.role.admin";
	public static final String APP_ROLE_USER = "eportal.app.default.role.user";
	/**
	 * Error constants
	 */
	public static final String LOGIN_INVALID = "login.invalid.credential";
	public static final String LOGIN_CREDENTIALS_EMPTY = "login.empty.credential";
	public static final String SESSION_NOT_FOUND = "session.user.not.found";
	/**
	 * ObjectModeler constants
	 */
	public static final String PLATFORM_OBJECT_STORE = "object-store"+File.separatorChar+"platform-objectmetadata.json";
	public static final String LIBRARY_OBJECT_STORE = "object-store"+File.separatorChar+"objects-library.json";
	/**
	 * Reusable Widget constants
	 */
	public static final String EP_WIDGET_PATH="widget-store";
	public static final String EP_WIDGET_LIB_JSON_NAME = "widget-library.json";
	public static final String EP_WIDGET_LIB_CONTENT_NAME = "widgets.html";
	public static final String EP_WIDGET_LIB_JSON_PATH=EP_WIDGET_PATH+File.separatorChar+EP_WIDGET_LIB_JSON_NAME;
	public static final String EP_WIDGET_LIB_CONTENT_PATH=EP_WIDGET_PATH+File.separatorChar+EP_WIDGET_LIB_CONTENT_NAME;
	/**
	 * Studio constants
	 */
	public static final String WORKSPACE="git";
	public static final String WORKSPACE_LOCAL="workspaceEPortal";
	public static final String SRC="src";
	public static final String PACKAGE_DEFAULT="com";
	public static final String MAIN="main";
	public static final String JAVA="java";
	public static final String WEBAPP="webapp";
	public static final String TARGET="target";
	public static final String WEBINF="WEB-INF";
	public static final String PROPERTIES="Properties";
	public static final String PRIVILEGES="Privileges";
	public static final String EP_API_PROPERTIES_JSON_NAME = "api-properties.json";
	public static final String STYLE="style";
	public static final String SCRIPT="script";
	public static final String CLASSES="classes";
	public static final String RESOURCES="resources";
	public static final String PAGES="pages";
	public static final String TEMPLATEPAGE="template";
	public static final String DEFAULT="default";
	public static final String USERAPP_FOLDER="userApp";
	public static final String IMAGEPATH=":APPNAME"+File.separatorChar+"images";
	public static final String CSSPATH_TOLOAD=":APPNAME"+File.separatorChar+"css"+File.separatorChar;
	public static final String PAGEPATH_TOSAVE=":APPNAME"+File.separatorChar+"pages"+File.separatorChar+":PAGENAME.jsp";
	public static final String CSSFILEPATH_TOSAVE=":APPNAME"+File.separatorChar+"css"+File.separatorChar+":CSSNAME.css";
	public static final String JSFILEPATH_TOSAVE=":APPNAME"+File.separatorChar+"js"+File.separatorChar+":JSNAME.js";
	public static final String MAP_JSON_PATH=":APPNAME"+File.separatorChar+"bindings"+File.separatorChar+"map-metadata.json";
	public static final String DEF_CSSPATH_TOSAVE="css"+File.separatorChar+"theme"+File.separatorChar+"app.css";
	public static final String APP_CSSPATH_TOSAVE=":APPNAME"+File.separatorChar+"css"+File.separatorChar+"theme"+File.separatorChar+"app.css";
	public static final String DEFAULT_TEMPLATEPATH="resources"+File.separatorChar+"design"+File.separatorChar+"template"+File.separatorChar+"pages"+File.separatorChar+TEMPLATEPAGE+".jsp";
	public static final String MODELS="models";
	public static final String WORKFLOWS="workflows";
	public static final String MAPMETADATAJSON="bindings";
	public static final String CSSPATH_TOSAVE=":APPNAME"+File.separatorChar+"css"+File.separatorChar+"theme"+File.separatorChar+":THEME.css";
	
	/**
	 * Package constants
	 */
	public static final String MODEL="model";
	public static final String IMPLEMENTATION="impl";
	public static final String API="api";
	public static final String DAO="dao";
	
	/*hibernate imports starts*/
	
	public static final String entity="javax.persistence.Entity";
	public static final String table="javax.persistence.Table";
	public static final String id="javax.persistence.Id";
	public static final String column="javax.persistence.Column";
	public static final String generatedValue="javax.persistence.GeneratedValue";
	public static final String oneToOne="javax.persistence.OneToOne";
	public static final String manyToMany="javax.persistence.ManyToMany";
	public static final String oneToMany="javax.persistence.OneToMany";
	public static final String manyToOne="javax.persistence.ManyToOne";
	public static final String JOIN_COLUMN_IMPORT="javax.persistence.JoinColumn";
	public static final String ENUMERATED="javax.persistence.Enumerated";
	public static final String CASCADE_ALL="CascadeType.ALL";
	public static final String IMPORT_CASCADE_ALL="javax.persistence.CascadeType";
	public static final String IMPORT_LAZY_COLLECTION="org.hibernate.annotations.LazyCollection";
	public static final String IMPORT_LAZY_COLLECTION_OPTION="org.hibernate.annotations.LazyCollectionOption";
	
	public static final String METHOD_START_DEBUG_MSG = "method execution started...";
	public static final String METHOD_END_DEBUG_MSG = "method execution ended...";
	
	public static final String ENUM="java.util.Enumeration";
	public static final String util="java.util.*";
	/*hibernate imports ends*/
	/*collection imports starts*/
	public static final String Set="java.util.Set";
	
	/*collection imports ends*/
	/*annotation names starts*/
	public static final String JOINCOLUMN="JoinColumn";
	/*annotation names ends*/
	
	/**
	 * PUBLISH MODULE CONSTANTS
	 */
	public static final String MYSQL="MYSQL";
	public static final String ORACLE="ORACLE";
	public static final String MYSQL_JDBC_REGEX="(?s)(<!-- MYSQL JDBC CONFIGURATIONS - START -->.*<!-- MYSQL JDBC CONFIGURATIONS - END -->)";
	public static final String ORACLE_JDBC_REGEX="(?s)(<!-- ORACLE JDBC CONFIGURATIONS - START -->.*<!-- ORACLE JDBC CONFIGURATIONS - END -->)";
	public static final String MAPPING_FILES_REGEX="(?s)<!-- MAPPING FILE - START  -->\\s{3}(.*)\\s{3}<!-- MAPPING FILE - END  -->";
	
	/*****CE CONSTANTS*****/
	public static final String GET="GET";
	public static final String POST="POST";
	public static final String PUT="PUT";
	public static final String DELETE="DELETE";
	/*public static final String DMNRULES_POST="platform.ceapp.rest.symptomsrules.post";
	public static final String SYMPTOMRULES_GET="platform.ceapp.rest.allsymptomsrules.get";
	public static final String CEAPP_DMNENGINE_ENDPOINT="platform.ceapp.engine.dmnrest.endpoint";
	public static final String SAVEORUPDATEDMNRULES_POST="platform.ceapp.rest.saveOrUpdateSymptomRule.post";
	public static final String setAsActive_POST="platform.ceapp.rest.setAsActive.post";
    public static final String getAllDmn_GET = "platform.ceapp.rest.getAllDmn.get";
	public static final String DELETEDECISIONBYID_DELETE="platform.ceapp.rest.deleteDecisionById.delete";
	public static final String SYMPTOMRULESCREATE_POST="platform.ceapp.rest.symptoms.create";*/
	
	/*****USER ADMIN*****/
	public static final String PLATFORM_SUPER_ADMIN_KEY = "superadmin";
	public static final String PLATFORM_AUTHN_X_TOKEN_KEY = "platform-X-XSRF-TOKEN";
	public static final String PLATFORM_AUTHN_USER_KEY = "platform-UserName";
	public static final String PLATFORM_AUTHN_CSRF_TOKEN = "X-CSRF-TOKEN";
	public static final String PLATFORM_AUTHZ_USER_RESOURCES = "platform-UserResource";
	public static final String PLATFORM_AUTHZ_TESTAPPS = "platform-test-app";
	public static final String PLATFORM_AUTHZ_USER_RESOURCES_API = "platform-UserResource-API";
	public static final String PLATFORM_AUTHZ_USER_ROLES = "platform-UserRoles";
	public static final String PLATFORM_AUTHZ_EPORTAL_ACCESS = "ep-menu-access";
	public static final String PLATFORM_DASHBOARD_KEY = "Dashboard";
	public static final String PLATFORM_createOrder_KEY = "createOrder";
	public static final String PLATFORM_order_search_KEY = "order-search";
	public static final String PLATFORM_Interface_mgmt_KEY = "Interface_mgmt";
	public static final String PLATFORM_manage_decision_KEY = "manage-decision";
	public static final String PLATFORM_processflow_KEY = "processflow";
	public static final String PLATFORM_service_catalog_KEY = "service-catalog";
	public static final String PLATFORM_admin_KEY = "admin";
	
	/*roleID*/
	public static final String PLATFORM_ROLE_SUPER_ADMIN_ID = "1";
	public static final String PLATFORM_ROLE_SUPER_ADMIN = "super admin";
	public static final String PLATFORM_ROLE_SUPER_ADMIN_DESC = "super admin";
	public static final String PLATFORM_PERMISSION_SUPER_ADMIN_ID = "1";	
	
	public static final String PLATFORM_ROLE_ACCOUNT_OWNER_ID = "2";
	public static final String PLATFORM_ROLE_ACCOUNT_OWNER = "account owner";
	public static final String PLATFORM_ROLE_ACCOUNT_OWNER_DESC = "account owner";
	public static final String PLATFORM_PERMISSION_ACCOUNT_OWNER_ID = "2";

	public static final String PLATFORM_ROLE_BUSINESS_ANALYSIST_ID = "3";
	public static final String PLATFORM_ROLE_BUSINESS_ANALYSIST = "business analyst";
	public static final String PLATFORM_ROLE_BUSINESS_ANALYSIST_DESC = "business analyst";
	public static final String PLATFORM_PERMISSION_BUSINESS_ANALYST_ID = "3";
	
	public static final String PLATFORM_ROLE_SOLUTION_ARCHITECH_ID = "4";
	public static final String PLATFORM_ROLE_SOLUTION_ARCHITECH = "solution architect";
	public static final String PLATFORM_ROLE_SOLUTION_ARCHITECH_DESC = "solution architect";
	public static final String PLATFORM_PERMISSION_SOLUTION_ARCHITECH_ID = "4";
	
	public static final String PLATFORM_ROLE_UX_DESGINER_ID = "5";
	public static final String PLATFORM_ROLE_UX_DESGINER = "ux designer";
	public static final String PLATFORM_ROLE_UX_DESGINER_DESC = "ux designer";
	public static final String PLATFORM_PERMISSION_UX_DESGINER_ID = "5";
	
	
	/* cloud config */
	public static final String PLATFORM_CLOUD_CONFIG_SERVICE ="eportal-service-{profile}";
	
	/* account name */
	public static final String PLATFORM_HEADER_ACCOUNT_NAME ="ep-accountname";
	public static final String PLATFORM_HEADER_APP_NAME ="ep-appname";
	
	/*dev portal*/
	public static final String APPLICATION_DEFAULT_ICON="doc-mgmt-icon.png";
	public static final String DRAFT_APPLICAITON_WORKSPACE_PATH="workspace";
	
	/** Connector*/
	public static final String CONNECTOR_DIRECTORY_PATH="connector-store" + File.separatorChar + "connector-store.json";
	public static final String INBUILT_CONNECTOR_DIRECTORY_PATH="app-connector.json";
	public static final String INBUILT_CONNECTOR_NAME="APPLICATION DB";
	public static final String APPLICATION_CONNECTOR_NAME="DATABASE";
	public static final String STORAGE_TYPE_CONNECTOR = "Connector";
	public static final String STORAGE_TYPE_CONNECTOR_CONFIG = "Connector_Config";
	public static final String STORAGE_TYPE_CONNECTOR_CONVERSIONMAP = "Connector_ConversionMap";
	/*for pageModeler*/
	public static final String EP_PAGEMOD_TEMP_EDITOR_PATH=":CONTEXTPATH"+":APP_CXT_PATH"+File.separatorChar+"pages"+File.separatorChar+":TEMP_FILE.jsp";
	public static final String EP_PAGEMOD_LINK_STRUCT = "<link :ACTIVETHEME ep-mode=\":MODE\" href=\":SRC\" rel=\"stylesheet\">";
	public static final String EP_PAGEMOD_SCRIPT_STRUCT = "<script ep-mode=\":MODE\" src=\":SRC\" type=\"text/javascript\"></script>";
	public static final String EP_PAGEMOD_ACTIVE_THEME_ID = "active_theme";
	public static final String EP_PAGEMOD_MODE_RUNTIME = "runtime";
	public static final String EP_PAGEMOD_MODE_DESIGN = "design";
	public static final String EP_PAGEMOD_SRC_MODE = "ep-mode";
	public static final String EP_PAGEMOD_LIB_PATH = ":CONTEXTPATH"+"resources"+File.separatorChar+"design"+File.separatorChar+"pageLibContext.json";
	public static final String EP_PAGEMOD_ANGULAR_TEMPLATE="<script type=\"text/javascript\">\n"+
															"var papp = angular.module(':NGAPP',[\"ngValidate\"]);\n"+
															"papp.controller(':NGCTRL', function($scope, $compile,$http) {\n"+
															"ep.pageUtil.pageCtrl($scope, $compile,$http);\n"+
															"bu.angular.pageCtrl($scope,undefined,$compile,$http);\n"+
															"});\n"+
															"</script>\n";
	public static final String EP_PAGEMOD_MAPPING_DETAILS_REGEX = "mapping_details\\s*=\\s*['\"]([^'\"]+)['\"](.*?)";
	public static final String EP_PAGEMOD_JSP_DESIGN_COMMENT_REGEX="<!--\\s*ep-design-comment(.*?)-->";
	public static final String EP_PAGEMOD_JSP_INCLUDE_REGEX="<jsp:include.*?>([\\s\\S]*?)<\\/jsp:include>";
	public static final String EP_PAGEMOD_JSP_INC_ALT="ep-jsp:include";
	public static final String EP_PAGEMOD_JSP_DESIGN_COMMENT="<!-- ep-design-comment :JSPTAG-->";
	public static final String EP_PAGEMOD_JS_FUNCTION_NAMES="function\\s+((\\w+)\\s*\\()";
	public static final List<String> EP_PAGEMOD_PAGE_LIST_IGNORE=Arrays.asList("temp-editor","header","dashboard","processLog","transactionLog","temp-editor");
	public static final String EP_PAGEMOD_TEMP_JSP_PREPEND="ep-temp";
	
	/*for theme moduler*/
	public static final String THEME_APP_PATH=":CXTPATH:APP_CXTPATH"+File.separatorChar+"css"+File.separatorChar+"theme"+File.separatorChar+":THEME.css";
	public static final String ACC_THEME_PATH=":CXTPATH:APP_CXTPATH"+File.separatorChar+"ep-theme"+File.separatorChar+":THEME.css";
	public static final String ACC_APP_PATH=":CXTPATH:APP_CXTPATH"+File.separatorChar;
	public static final String THEME_PAGE_PATH=":CXTPATH:APP_CXTPATH"+File.separatorChar;
	public static final String THEME_SYSTEM_LEVEL_PATH=":CXTPATH"+"theme-store";
	public static final String ACCOUNT_LEVEL_THEME_PATH="ep-theme";
	public static final String THEME_SYSTEM_LIST_JSON="theme-library.json";
	public static final String STORAGE_TYPE_THEME_CSS = "theme::css";
	public static final String ACC_LOGO_PATH=":CXTPATH:APP_CXTPATH"+File.separatorChar+"images"+File.separatorChar+"icon"+File.separatorChar+"logo";
	
	
	public static final String STORAGE_TYPE_CONNECTOR_DDL = "ConnectorDDL";
//	public static final String STORAGE_TYPE_CONNECTOR = "Connector";
	public static final String STORAGE_TYPE_APP_DB_CONNECTOR = "AppDBConnector";
	public static final String STORAGE_TYPE_CREDENTIAL = "Credential";
//	public static final String STORAGE_TYPE_CONNECTOR_CONFIG = "Connector_Config";
//	public static final String STORAGE_TYPE_CONNECTOR_CONVERSIONMAP = "Connector_ConversionMap";
	public static final String STORAGE_TYPE_ACTIONFLOW = "ActionFlow";
	public static final String STORAGE_TYPE_MENU = "Menu";
	public static final String STORAGE_TYPE_OBJECT = "Object";
	public static final String STORAGE_TYPE_THEME_JSON = "theme::json";
//	public static final String STORAGE_TYPE_THEME_CSS = "theme::css";
	public static final String STORAGE_TYPE_DASHBOARD = "Dashboard";
	public static final String STORAGE_TYPE_DASHBOARD_Theme = "DashboardTheme";
	public static final String STORAGE_TYPE_DASHBOARD_DATASOURCE = "DashboardDatasource";
	public static final String STORAGE_TYPE_ACCOUNT_CONFIG = "Account_Config";

	public static final String STORAGE_PATH_CONNECTOR_DDL = File.separatorChar + "ep-connector" + File.separatorChar + "***" + File.separatorChar + "connectionDDL.sql";
	public static final String STORAGE_PATH_CONNECTOR = File.separatorChar + "ep-connector" + File.separatorChar + "connector.json";
	public static final String STORAGE_PATH_CREDENTIAL = File.separatorChar + "ep-connector" + File.separatorChar + "credential.json";
	public static final String STORAGE_PATH_CONNECTOR_CONFIG = File.separatorChar + "ep-connector" + File.separatorChar + "***" + File.separatorChar + "config.json";
	public static final String STORAGE_PATH_CONNECTOR_CONVERSIONMAP = File.separatorChar + "ep-connector" + File.separatorChar + "***" + File.separatorChar + "conversionMap.json";
	public static final String STORAGE_PATH_ACTIONFLOW = File.separatorChar + "actions" + File.separatorChar + "action-metadata.json";
	public static final String STORAGE_PATH_MENU = File.separatorChar + "menu" + File.separatorChar + "menu.json";
	public static final String STORAGE_PATH_OBJECT = File.separatorChar + "objects" + File.separatorChar + "object-metadata.json";
	public static final String STORAGE_PATH_THEME = File.separatorChar+"theme-store";
	public static final String STORAGE_PATH_THEME_JSON_NAME="theme-library.json";
	public static final String STORAGE_PATH_THEME_JSON = STORAGE_PATH_THEME_JSON_NAME;
	public static final String STORAGE_PATH_THEME_CSS = ":CSS_NAME";
	public static final String STORAGE_TYPE_FILEPATH_DASHBOARD = File.separatorChar + "dashboard" + File.separatorChar + "dashboard-metadata.json";
	public static final String STORAGE_TYPE_FILEPATH_DASHBOARD_THEME =File.separatorChar + "dashboard" + File.separatorChar + "theme-metadata.json";
	public static final String STORAGE_TYPE_FILEPATH_DASHBOARD_DATASOURCE = File.separatorChar + "dashboard" + File.separatorChar + "datasource-metadata.json";
	public static final String STORAGE_PATH_ACCOUNT_CONFIG = File.separatorChar + "accountConfig.json";

	public static final String STORAGE_CACHE_CONNECTOR_DDL = "ConnectorsDDL";
	public static final String STORAGE_CACHE_CONNECTOR = "Connectors";
	public static final String STORAGE_CACHE_APP_DB_CONNECTOR = "AppDB_ConfiguredId";
	public static final String STORAGE_CACHE_CREDENTIAL = "Credentials";
	public static final String STORAGE_CACHE_CONNECTOR_CONFIG = "ConnectorConfig_***";
	public static final String STORAGE_CACHE_CONNECTOR_CONVERSIONMAP = "ConnectorConversionMap_***";
	public static final String STORAGE_CACHE_ACTIONFLOW = "ActionFlow";
	public static final String STORAGE_CACHE_MENU = "Menu";
	public static final String STORAGE_CACHE_OBJECT = "Object";
	public static final String STORAGE_CACHE_THEME = "theme";
	public static final String STORAGE_CACHE_THEME_JSON = "json";
	public static final String STORAGE_CACHE_THEME_CSS = ":CSS";
	public static final String STORAGE_CACHE_ACCOUNT_CONFIG = "AccountConfig";
	public static final String EP_CLIENT_VALUE = "eportal-web-ui-service";
	public static final String EP_CLIENT = "ep-client";
	public static final String EP_LINK_ID = "ep_link_id";
}