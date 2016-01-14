Ext.define('Testpro1.view.reportui.ReportView', {
	extend : 'Ext.panel.Panel',
	requires : [ 'Testpro1.view.reportui.querycriteria.QueryCriteriaView',
			'Testpro1.view.reportui.datachart.DataChartViewTab',
			'Testpro1.view.reportui.datachart.DataChartViewPanel',
			'Testpro1.view.reportui.ReportViewController' ,
			'Testpro1.view.fw.MainDataPointPanel',
			'Testpro1.view.googlemaps.map.MapPanel'
			],
	xtype : 'reportview',
	controller : 'reportviewController',
	layout : 'border',
	reportWidgets :["1","2","3","4"],
	//autoScroll : true,
	//margin : '3 0 5 0',
	height:500,
	width:"100%",
	listeners : {
		scope : 'controller',
		afterrender : 'renderReport'
	}
});
