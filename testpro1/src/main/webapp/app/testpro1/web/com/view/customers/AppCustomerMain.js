Ext.define('Testpro1.testpro1.web.com.view.customers.AppCustomerMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "AppCustomerMainController",
     "restURL": "/AppCustomer",
     "defaults": {
          "split": true
     },
     "requires": ["Testpro1.testpro1.shared.com.model.customers.AppCustomerModel", "Testpro1.testpro1.web.com.controller.customers.AppCustomerMainController", "Testpro1.testpro1.shared.com.model.contacts.CoreContactsModel", "Testpro1.testpro1.shared.com.model.customers.AppCustomerTypeModel", "Testpro1.testpro1.shared.com.model.customers.AppCustomerCategoryModel", "Testpro1.testpro1.shared.com.viewmodel.customers.AppCustomerViewModel"],
     "communicationLog": [],
     "tabPosition": "bottom",
     "items": [{
          "title": "Data Browser",
          "layout": "border",
          "defaults": {
               "split": true
          },
          "autoScroll": false,
          "customWidgetType": "vdBorderLayout",
          "items": [{
               "xtype": "tabpanel",
               "customWidgetType": "vdTabLayout",
               "margin": "5 0 5 5",
               "border": 1,
               "style": {
                    "borderColor": "#f6f6f6",
                    "borderStyle": "solid",
                    "borderWidth": "1px"
               },
               "displayName": "AppCustomer",
               "name": "AppCustomerTreeContainer",
               "itemId": "AppCustomerTreeContainer",
               "restURL": "/AppCustomer",
               "autoScroll": false,
               "collapsible": true,
               "titleCollapse": true,
               "collapseMode": "header",
               "collapsed": false,
               "items": [{
                    "xtype": "treepanel",
                    "customWidgetType": "vdTree",
                    "title": "Browse",
                    "useArrows": true,
                    "rootVisible": false,
                    "itemId": "AppCustomerTree",
                    "listeners": {
                         "select": "treeClick"
                    },
                    "tbar": [{
                         "xtype": "triggerfield",
                         "customWidgetType": "vdTriggerField",
                         "emptyText": "Search",
                         "triggerCls": "",
                         "listeners": {
                              "change": "onTriggerfieldChange",
                              "buffer": 250
                         }
                    }, "->", {
                         "xtype": "tool",
                         "type": "refresh",
                         "tooltip": "Refresh Tree Data",
                         "handler": "onTreeRefreshClick"
                    }]
               }, {
                    "title": "Advance Search",
                    "xtype": "form",
                    "customWidgetType": "vdFormpanel",
                    "itemId": "queryPanel",
                    "dockedItems": [{
                         "xtype ": "toolbar",
                         "customWidgetType": "vdBBar",
                         "dock": "bottom",
                         "isDockedItem": true,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill"
                         }, {
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "text": "Filter",
                              "handler": "onFilterClick"
                         }]
                    }],
                    "items": [{
                         "name": "customerName",
                         "itemId": "customerName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Name",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Name",
                         "fieldId": "4C86D8C8-078A-4837-8B16-9F036DF6973C",
                         "minLength": "0",
                         "maxLength": "65535"
                    }]
               }],
               "region": "west",
               "width": "20%"
          }, {
               "region": "center",
               "layout": "border",
               "defaults": {
                    "split": true
               },
               "customWidgetType": "vdBorderLayout",
               "items": [{
                    "customWidgetType": "vdFormpanel",
                    "viewModel": "AppCustomerViewModel",
                    "xtype": "form",
                    "displayName": "AppCustomer",
                    "title": "AppCustomer",
                    "name": "AppCustomer",
                    "itemId": "AppCustomer",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "appCustomerId",
                         "itemId": "appCustomerId",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "AppCustomer Id",
                         "margin": "5 5 5 5",
                         "fieldLabel": "AppCustomer Id<font color='red'> *<\/font>",
                         "fieldId": "038CA07C-E610-4163-8412-BE6B83B343F8",
                         "hidden": true,
                         "value": "",
                         "bindable": "appCustomerId",
                         "bind": "{appCustomerId}"
                    }, {
                         "name": "customerName",
                         "itemId": "customerName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Name",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Name<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "4C86D8C8-078A-4837-8B16-9F036DF6973C",
                         "minLength": "0",
                         "maxLength": "65535",
                         "bindable": "customerName",
                         "bind": "{customerName}",
                         "columnWidth": 0.5
                    }, {
                         "name": "contactId",
                         "itemId": "contactId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Contact",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Contact<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "5114860F-B87F-4999-8F6C-9E20F1822CFE",
                         "restURL": "CoreContacts",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Testpro1.testpro1.shared.com.model.contacts.CoreContactsModel"
                         },
                         "bindable": "contactId",
                         "bind": "{contactId}",
                         "columnWidth": 0.5
                    }, {
                         "name": "appCustomerType",
                         "itemId": "appCustomerType",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Customer Type",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Customer Type<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "B5B8349F-5F71-458A-9F9C-B96E9D880F83",
                         "restURL": "AppCustomerType",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Testpro1.testpro1.shared.com.model.customers.AppCustomerTypeModel"
                         },
                         "bindable": "appCustomerType",
                         "bind": "{appCustomerType}",
                         "columnWidth": 0.5
                    }, {
                         "name": "appCustomerCategory",
                         "itemId": "appCustomerCategory",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Customer Category",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Customer Category<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "8752B96C-554C-4C1D-BBC6-158EE8C6820F",
                         "restURL": "AppCustomerCategory",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Testpro1.testpro1.shared.com.model.customers.AppCustomerCategoryModel"
                         },
                         "bindable": "appCustomerCategory",
                         "bind": "{appCustomerCategory}",
                         "columnWidth": 0.5
                    }, {
                         "name": "deploymentModel",
                         "itemId": "deploymentModel",
                         "xtype": "checkbox",
                         "customWidgetType": "vdCheckbox",
                         "displayName": "Deployment Model",
                         "margin": "5 5 5 5",
                         "value": "1",
                         "inputValue": true,
                         "fieldLabel": "Deployment Model<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "E34DCD99-972A-4AAC-8B97-95513F7D73C7",
                         "bindable": "deploymentModel",
                         "bind": "{deploymentModel}",
                         "columnWidth": 0.5
                    }, {
                         "name": "customerStatus",
                         "itemId": "customerStatus",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Customer Status",
                         "margin": "5 5 5 5",
                         "value": "1",
                         "fieldLabel": "Customer Status<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "CCCBA0C2-09F7-469D-94FF-D5A1936D263B",
                         "minValue": "0",
                         "maxValue": "1",
                         "bindable": "customerStatus",
                         "bind": "{customerStatus}",
                         "columnWidth": 0.5
                    }, {
                         "name": "userRequested",
                         "itemId": "userRequested",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "User Requested",
                         "margin": "5 5 5 5",
                         "value": "1",
                         "fieldLabel": "User Requested<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "5B518F7F-070F-4382-B7C8-DD23D91C3B93",
                         "minValue": "-2147483648",
                         "maxValue": "2147483647",
                         "bindable": "userRequested",
                         "bind": "{userRequested}",
                         "columnWidth": 0.5
                    }, {
                         "name": "evalTimePeriod",
                         "itemId": "evalTimePeriod",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Eval Time Period",
                         "margin": "5 5 5 5",
                         "value": "60",
                         "fieldLabel": "Eval Time Period<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "10C2BCEA-9AFF-4160-84AF-25D8D5172F64",
                         "minValue": "-2147483648",
                         "maxValue": "2147483647",
                         "bindable": "evalTimePeriod",
                         "bind": "{evalTimePeriod}",
                         "columnWidth": 0.5
                    }, {
                         "name": "versionId",
                         "itemId": "versionId",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "versionId",
                         "margin": "5 5 5 5",
                         "value": "-1",
                         "fieldLabel": "versionId",
                         "fieldId": "B08C67E0-4E46-4BAD-BC83-92FCBDD280C3",
                         "bindable": "versionId",
                         "bind": "{versionId}",
                         "hidden": true
                    }],
                    "layout": "column",
                    "defaults": {
                         "columnWidth": 0.5,
                         "labelAlign": "left",
                         "labelWidth": 200
                    },
                    "autoScroll": true,
                    "dockedItems": [{
                         "xtype ": "toolbar",
                         "customWidgetType": "vdBBar",
                         "dock": "bottom",
                         "ui": "footer",
                         "isDockedItem": true,
                         "parentId": 1,
                         "customId": 915,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 915,
                              "customId": 732
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 915,
                              "customId": 733,
                              "listeners": {
                                   "click": "saveForm"
                              }
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "margin": "0 5 0 5",
                              "text": "Reset",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "resetFormButton",
                              "parentId": 915,
                              "customId": 734,
                              "listeners": {
                                   "click": "resetForm"
                              }
                         }],
                         "defaults": {}
                    }],
                    "listeners": {
                         "scope": "controller"
                    },
                    "tools": [{
                         "type": "help",
                         "tooltip": "Console",
                         "handler": "onConsoleClick"
                    }, {
                         "type": "refresh",
                         "tooltip": "Refresh Tab",
                         "handler": "init"
                    }],
                    "extend": "Ext.form.Panel",
                    "region": "center"
               }, {
                    "xtype": "gridpanel",
                    "customWidgetType": "vdGrid",
                    "displayName": "AppCustomer",
                    "title": "Details Grid",
                    "name": "AppCustomerGrid",
                    "itemId": "AppCustomerGrid",
                    "restURL": "/AppCustomer",
                    "store": [],
                    "bodyPadding": 10,
                    "columns": [{
                         "header": "AppCustomer Id",
                         "dataIndex": "appCustomerId",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "primaryDisplay",
                         "dataIndex": "primaryDisplay",
                         "hidden": true
                    }, {
                         "header": "primaryKey",
                         "dataIndex": "primaryKey",
                         "hidden": true
                    }, {
                         "header": "Name",
                         "dataIndex": "customerName",
                         "flex": 1
                    }, {
                         "header": "Contact",
                         "dataIndex": "contactId",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "Customer Type",
                         "dataIndex": "appCustomerType",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "Customer Category",
                         "dataIndex": "appCustomerCategory",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "Deployment Model",
                         "dataIndex": "deploymentModel",
                         "flex": 1
                    }, {
                         "header": "Customer Status",
                         "dataIndex": "customerStatus",
                         "flex": 1
                    }, {
                         "header": "User Requested",
                         "dataIndex": "userRequested",
                         "flex": 1
                    }, {
                         "header": "Eval Time Period",
                         "dataIndex": "evalTimePeriod",
                         "flex": 1
                    }, {
                         "header": "createdBy",
                         "dataIndex": "createdBy",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "createdDate",
                         "dataIndex": "createdDate",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "updatedBy",
                         "dataIndex": "updatedBy",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "updatedDate",
                         "dataIndex": "updatedDate",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "versionId",
                         "dataIndex": "versionId",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "activeStatus",
                         "dataIndex": "activeStatus",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "txnAccessCode",
                         "dataIndex": "txnAccessCode",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "xtype": "actioncolumn",
                         "customWidgetType": "vdActionColumn",
                         "width": 30,
                         "sortable": false,
                         "menuDisable": true,
                         "items": [{
                              "icon": "images/delete.gif",
                              "tooltip": "Delete Record",
                              "handler": "onDeleteActionColumnClickMainGrid"
                         }]
                    }],
                    "listeners": {
                         "itemclick": "onGridItemClick"
                    },
                    "tools": [{
                         "type": "refresh",
                         "tooltip": "Refresh Grid Data",
                         "handler": "onGridRefreshClick"
                    }],
                    "collapsible": true,
                    "titleCollapse": true,
                    "collapseMode": "header",
                    "region": "south",
                    "height": "40%"
               }]
          }]
     }, {
          "title": "Add New",
          "itemId": "addNewForm",
          "layout": "border",
          "customWidgetType": "vdBorderLayout",
          "autoScroll": false,
          "items": [{
               "customWidgetType": "vdFormpanel",
               "viewModel": "AppCustomerViewModel",
               "xtype": "form",
               "displayName": "AppCustomer",
               "title": "AppCustomer",
               "name": "AppCustomer",
               "itemId": "AppCustomer",
               "bodyPadding": 10,
               "items": [{
                    "name": "appCustomerId",
                    "itemId": "appCustomerId",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "AppCustomer Id",
                    "margin": "5 5 5 5",
                    "fieldLabel": "AppCustomer Id<font color='red'> *<\/font>",
                    "fieldId": "038CA07C-E610-4163-8412-BE6B83B343F8",
                    "hidden": true,
                    "value": "",
                    "bindable": "appCustomerId",
                    "bind": "{appCustomerId}"
               }, {
                    "name": "customerName",
                    "itemId": "customerName",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Name",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Name<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "4C86D8C8-078A-4837-8B16-9F036DF6973C",
                    "minLength": "0",
                    "maxLength": "65535",
                    "bindable": "customerName",
                    "bind": "{customerName}",
                    "columnWidth": 0.5
               }, {
                    "name": "contactId",
                    "itemId": "contactId",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "Contact",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Contact<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "5114860F-B87F-4999-8F6C-9E20F1822CFE",
                    "restURL": "CoreContacts",
                    "displayField": "primaryDisplay",
                    "valueField": "primaryKey",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Testpro1.testpro1.shared.com.model.contacts.CoreContactsModel"
                    },
                    "bindable": "contactId",
                    "bind": "{contactId}",
                    "columnWidth": 0.5
               }, {
                    "name": "appCustomerType",
                    "itemId": "appCustomerType",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "Customer Type",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Customer Type<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "B5B8349F-5F71-458A-9F9C-B96E9D880F83",
                    "restURL": "AppCustomerType",
                    "displayField": "primaryDisplay",
                    "valueField": "primaryKey",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Testpro1.testpro1.shared.com.model.customers.AppCustomerTypeModel"
                    },
                    "bindable": "appCustomerType",
                    "bind": "{appCustomerType}",
                    "columnWidth": 0.5
               }, {
                    "name": "appCustomerCategory",
                    "itemId": "appCustomerCategory",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "Customer Category",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Customer Category<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "8752B96C-554C-4C1D-BBC6-158EE8C6820F",
                    "restURL": "AppCustomerCategory",
                    "displayField": "primaryDisplay",
                    "valueField": "primaryKey",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Testpro1.testpro1.shared.com.model.customers.AppCustomerCategoryModel"
                    },
                    "bindable": "appCustomerCategory",
                    "bind": "{appCustomerCategory}",
                    "columnWidth": 0.5
               }, {
                    "name": "deploymentModel",
                    "itemId": "deploymentModel",
                    "xtype": "checkbox",
                    "customWidgetType": "vdCheckbox",
                    "displayName": "Deployment Model",
                    "margin": "5 5 5 5",
                    "value": "1",
                    "inputValue": true,
                    "fieldLabel": "Deployment Model<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "E34DCD99-972A-4AAC-8B97-95513F7D73C7",
                    "bindable": "deploymentModel",
                    "bind": "{deploymentModel}",
                    "columnWidth": 0.5
               }, {
                    "name": "customerStatus",
                    "itemId": "customerStatus",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "Customer Status",
                    "margin": "5 5 5 5",
                    "value": "1",
                    "fieldLabel": "Customer Status<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "CCCBA0C2-09F7-469D-94FF-D5A1936D263B",
                    "minValue": "0",
                    "maxValue": "1",
                    "bindable": "customerStatus",
                    "bind": "{customerStatus}",
                    "columnWidth": 0.5
               }, {
                    "name": "userRequested",
                    "itemId": "userRequested",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "User Requested",
                    "margin": "5 5 5 5",
                    "value": "1",
                    "fieldLabel": "User Requested<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "5B518F7F-070F-4382-B7C8-DD23D91C3B93",
                    "minValue": "-2147483648",
                    "maxValue": "2147483647",
                    "bindable": "userRequested",
                    "bind": "{userRequested}",
                    "columnWidth": 0.5
               }, {
                    "name": "evalTimePeriod",
                    "itemId": "evalTimePeriod",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "Eval Time Period",
                    "margin": "5 5 5 5",
                    "value": "60",
                    "fieldLabel": "Eval Time Period<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "10C2BCEA-9AFF-4160-84AF-25D8D5172F64",
                    "minValue": "-2147483648",
                    "maxValue": "2147483647",
                    "bindable": "evalTimePeriod",
                    "bind": "{evalTimePeriod}",
                    "columnWidth": 0.5
               }, {
                    "name": "versionId",
                    "itemId": "versionId",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "versionId",
                    "margin": "5 5 5 5",
                    "value": "-1",
                    "fieldLabel": "versionId",
                    "fieldId": "B08C67E0-4E46-4BAD-BC83-92FCBDD280C3",
                    "bindable": "versionId",
                    "bind": "{versionId}",
                    "hidden": true
               }],
               "layout": "column",
               "defaults": {
                    "columnWidth": 0.5,
                    "labelAlign": "left",
                    "labelWidth": 200
               },
               "autoScroll": true,
               "dockedItems": [{
                    "xtype ": "toolbar",
                    "customWidgetType": "vdBBar",
                    "dock": "bottom",
                    "ui": "footer",
                    "isDockedItem": true,
                    "parentId": 1,
                    "customId": 915,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 915,
                         "customId": 732
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 915,
                         "customId": 733,
                         "listeners": {
                              "click": "saveForm"
                         }
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "margin": "0 5 0 5",
                         "text": "Reset",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "resetFormButton",
                         "parentId": 915,
                         "customId": 734,
                         "listeners": {
                              "click": "resetForm"
                         }
                    }],
                    "defaults": {}
               }],
               "listeners": {
                    "scope": "controller"
               },
               "tools": [{
                    "type": "help",
                    "tooltip": "Console",
                    "handler": "onConsoleClick"
               }, {
                    "type": "refresh",
                    "tooltip": "Refresh Tab",
                    "handler": "init"
               }],
               "extend": "Ext.form.Panel",
               "region": "center"
          }]
     }]
});