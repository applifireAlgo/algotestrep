/**
 * 
 */
Ext.define('Testpro1.view.searchengine.search.ReportChartView',{
	extend : 'Ext.panel.Panel',
	xtype: 'reportChartView',
	margin:'5 5 0 0',
	chartJson : null,
	border:1,
	requires: ['Testpro1.view.searchengine.search.ReportChartController'],
	
	controller:'reportChartController',
	listeners :{
		  scope:'controller',
		  afterrender : 'onAfterrender'
	}
});