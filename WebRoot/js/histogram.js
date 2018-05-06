	alert('fff');
    var chart = Highcharts.chart('histogram', {
        title: {
            text: '图表变换'
        },
        subtitle: {
            text: '普通的'
        },
        xAxis: {
            categories: ['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月']
        },
        series: [{
            type: 'column',
            colorByPoint: true,
            data: [29.9, 71.5, 106.4, 129.2, 144.0, 176.0, 135.6, 148.5, 216.4, 194.1, 95.6, 54.4],
            showInLegend: false
        }]
    });
    $('#plain').click(function () {
    	alert('fff');
        chart.update({
            chart: {
                inverted: false,
                polar: false
            },
            subtitle: {
                text: '普通的'
            }
        });
    });
    $('#inverted').click(function () {
        // chart.update 支持全部属性动态更新
        chart.update({
            chart: {
                inverted: true,
                polar: false
            },
            subtitle: {
                text: '反转'
            }
        });
    });
    $('#polar').click(function () {
        chart.update({
            chart: {
                inverted: false,
                polar: true
            },
            subtitle: {
                text: '极地图'
            }
        });
    });
