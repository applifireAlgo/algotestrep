Ext.define('Testpro1.view.reportbuilder.properties.PropertiesPanelView', {
	extend : 'Ext.panel.Panel',
	requires : [ 'Testpro1.view.reportbuilder.properties.RptDrillDownGridView',
			'Testpro1.view.reportbuilder.properties.RptDataEndPointGridView',
			'Testpro1.view.reportbuilder.properties.RptChartPropGridView',
			'Ext.grid.property.Grid',
			'Testpro1.view.reportbuilder.properties.SearchConfigView', 
			'Testpro1.view.reportbuilder.properties.ActionButtonView'],
	xtype : 'property-panel',
	titleCollapse : true,
	split : true,
	collapsed : false,
	// autoScroll:true,
	itemId : 'propertypanel',
	layout : {
		/*
		 * type : 'vbox', padding : 1, strechmax : true
		 */
		type : 'accordion',
		animate : true
	},
	width : '22%',
	collapsible : true, // make collapsible
	items : [ {
		title : 'Step 3: Data Point Properties',
		xtype : 'dataendpoint-grid-view',
		width : '100%',
	// flex : 0.333333333,
	}, {
		title : 'Step 4: Drill Down Report Properties',
		xtype : 'drilldown-grid-view',
		width : '100%',
	// flex : 0.333333333,
	}, {
		title : 'Step 5: Chart Properties',
		xtype : 'chartPropGridView',
		width : '100%',
	// flex : 0.333333333,
	}, {
		xtype : 'search-config-view',
		title : 'Search Config',
		width : '100%',
		collapsible : true,
		collapseDirection : 'bottom',
		autoScroll : true,
		flex : 0.333333333
	},
	  {
		xtype : 'action-button-view',
		title : 'Action Button Config',
		width : '100%',
		collapsible : true,
		collapseDirection : 'bottom',
		autoScroll : true,
		flex : 0.333333333
	} ]
});