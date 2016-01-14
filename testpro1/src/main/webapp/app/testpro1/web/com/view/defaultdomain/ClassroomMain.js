Ext.define('Testpro1.testpro1.web.com.view.defaultdomain.ClassroomMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "ClassroomMainController",
     "restURL": "/Classroom",
     "defaults": {
          "split": true
     },
     "requires": ["Testpro1.testpro1.shared.com.model.defaultdomain.ClassroomModel", "Testpro1.testpro1.web.com.controller.defaultdomain.ClassroomMainController", "Testpro1.testpro1.shared.com.viewmodel.defaultdomain.ClassroomViewModel"],
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
               "displayName": "classroom",
               "name": "ClassroomTreeContainer",
               "itemId": "ClassroomTreeContainer",
               "restURL": "/Classroom",
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
                    "itemId": "ClassroomTree",
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
                    "items": []
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
                    "viewModel": "ClassroomViewModel",
                    "xtype": "form",
                    "displayName": "classroom",
                    "title": "classroom",
                    "name": "Classroom",
                    "itemId": "Classroom",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "classId",
                         "itemId": "classId",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "classId",
                         "margin": "5 5 5 5",
                         "fieldLabel": "classId<font color='red'> *<\/font>",
                         "fieldId": "BEA56BA7-BC22-4029-ADFA-3D94DB60D06F",
                         "hidden": true,
                         "value": "",
                         "bindable": "classId",
                         "bind": "{classId}"
                    }, {
                         "name": "standard",
                         "itemId": "standard",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "standard",
                         "margin": "5 5 5 5",
                         "fieldLabel": "standard<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "F45FAD4F-07C5-479A-BE69-3C5E090C385B",
                         "minValue": "-2147483648",
                         "maxValue": "2147483647",
                         "bindable": "standard",
                         "bind": "{standard}",
                         "columnWidth": 0.5
                    }, {
                         "name": "totalStudents",
                         "itemId": "totalStudents",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "totalStudents",
                         "margin": "5 5 5 5",
                         "fieldLabel": "totalStudents<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "E1BE1F7A-BCA0-476D-ACBA-FFDE010ED063",
                         "minValue": "-2147483648",
                         "maxValue": "2147483647",
                         "bindable": "totalStudents",
                         "bind": "{totalStudents}",
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
                         "fieldId": "6B2085C1-C696-4B83-908C-7297E784B2D4",
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
                         "customId": 786,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 786,
                              "customId": 885
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 786,
                              "customId": 886,
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
                              "parentId": 786,
                              "customId": 887,
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
                    "displayName": "classroom",
                    "title": "Details Grid",
                    "name": "ClassroomGrid",
                    "itemId": "ClassroomGrid",
                    "restURL": "/Classroom",
                    "store": [],
                    "bodyPadding": 10,
                    "columns": [{
                         "header": "classId",
                         "dataIndex": "classId",
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
                         "header": "standard",
                         "dataIndex": "standard",
                         "flex": 1
                    }, {
                         "header": "totalStudents",
                         "dataIndex": "totalStudents",
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
               "viewModel": "ClassroomViewModel",
               "xtype": "form",
               "displayName": "classroom",
               "title": "classroom",
               "name": "Classroom",
               "itemId": "Classroom",
               "bodyPadding": 10,
               "items": [{
                    "name": "classId",
                    "itemId": "classId",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "classId",
                    "margin": "5 5 5 5",
                    "fieldLabel": "classId<font color='red'> *<\/font>",
                    "fieldId": "BEA56BA7-BC22-4029-ADFA-3D94DB60D06F",
                    "hidden": true,
                    "value": "",
                    "bindable": "classId",
                    "bind": "{classId}"
               }, {
                    "name": "standard",
                    "itemId": "standard",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "standard",
                    "margin": "5 5 5 5",
                    "fieldLabel": "standard<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "F45FAD4F-07C5-479A-BE69-3C5E090C385B",
                    "minValue": "-2147483648",
                    "maxValue": "2147483647",
                    "bindable": "standard",
                    "bind": "{standard}",
                    "columnWidth": 0.5
               }, {
                    "name": "totalStudents",
                    "itemId": "totalStudents",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "totalStudents",
                    "margin": "5 5 5 5",
                    "fieldLabel": "totalStudents<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "E1BE1F7A-BCA0-476D-ACBA-FFDE010ED063",
                    "minValue": "-2147483648",
                    "maxValue": "2147483647",
                    "bindable": "totalStudents",
                    "bind": "{totalStudents}",
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
                    "fieldId": "6B2085C1-C696-4B83-908C-7297E784B2D4",
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
                    "customId": 786,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 786,
                         "customId": 885
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 786,
                         "customId": 886,
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
                         "parentId": 786,
                         "customId": 887,
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