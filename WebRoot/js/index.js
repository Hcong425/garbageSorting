		

$(function () {
	
	$(function () { $("[data-toggle='tooltip']").tooltip(); });
	
	var my_skin = {  
/*		    //颜色数组，默认从数组第一个元素取色  
		    colors: ["#33FF33", "#f45b5b", "#7798BF", "#aaeeee", "#ff0066", "#eeaaee",  
		        "#55BF3B", "#DF5353", "#7798BF", "#aaeeee"],  
		    //背景透明  
*/		    chart: {  
		        backgroundColor:'rgba(0,0,0,0)',  
		    } ,
			title: {
				text:null,
			},
/*		     
		    //title白色字  
		    title: {
		        style: {
		            color: '#000',
		            font: '16px "Trebuchet MS", Verdana, sans-serif'
		        }
		    },
		    subtitle: {
		        style: {
		            color: '#666666',
		            font: 'bold 12px "Trebuchet MS", Verdana, sans-serif'
		        }
		    },

		    legend: {
		        itemStyle: {
		            font: '9pt Trebuchet MS, Verdana, sans-serif',
		            color: 'black'
		        },
		        itemHoverStyle:{
		            color: 'gray'
		        }   
		    },
		//这个属性常用于饼图的时候对每个区域的说明  
		    plotOptions: {  
		            pie: {  
		                innerSize: 100,  
		                depth: 45,  
		                dataLabels: {  
		                    distance:7,  
		                    enabled: true,  
		                    color: '#555',  
		                    connectorColor:'#555',  
		//默认是 format: '<b>{point.name}</b>: {point.percentage:.1f} %'显示百分比  
		                    formatter: function(){//自定义显示  
		                        return '<b>' + this.point.name + ':（' + this.y +'）</b>';  
		                    }   
		                }  
		            }  
		        },  
		      
		    //x,y轴上的字白色  
		    xAxis: {  
		        labels: {  
		            style: {  
		                color: '#555'  
		            }  
		        }         
		    },  
		      
		    yAxis: {  
		        title: {  
		            style:{ "color": "#555"}  
		        },  
		        markable:{enabled:false},//不显示每一个点的实心  
		        labels: {  
		            style: {  
		                color: '#555'  
		            }  
		        },   
		         
		    },  
		      
		    //图例上的字白色  
		    legend: {  
		        itemStyle: {  
		            font: '9pt Trebuchet MS, Verdana, sans-serif',  
		            color: '#555'  
		        }  
		    },  
		    exporting: {enabled:false},//隐藏导出按钮  
		   plotOptions: {  
		        series: {  
		            dataLabels: {//影响条形图上数字的字体颜色  
		                color: '#000000'  
		            }  
		        }  
		    } */ 
		}  
	
	Highcharts.setOptions(my_skin);
	$.getJSON('https://data.jianshukeji.com/jsonp?filename=json/usdeur.json&callback=?', function (data) {
	    chart = Highcharts.chart('commodity', {
	        chart: {
	            zoomType: 'x'
	        },
	        xAxis: {
	            type: 'datetime',
	            dateTimeLabelFormats: {
	                millisecond: '%H:%M:%S.%L',
	                second: '%H:%M:%S',
	                minute: '%H:%M',
	                hour: '%H:%M',
	                day: '%m-%d',
	                week: '%m-%d',
	                month: '%Y-%m',
	                year: '%Y'
	            }
	        },
	        tooltip: {
	            dateTimeLabelFormats: {
	                millisecond: '%H:%M:%S.%L',
	                second: '%H:%M:%S',
	                minute: '%H:%M',
	                hour: '%H:%M',
	                day: '%Y-%m-%d',
	                week: '%m-%d',
	                month: '%Y-%m',
	                year: '%Y'
	            }
	        },
	        yAxis: {
	            title: {
	                text: '汇率'
	            }
	        },
	        legend: {
	            enabled: false
	        },
	        plotOptions: {
	            area: {
	                fillColor: {
	                    linearGradient: {
	                        x1: 0,
	                        y1: 0,
	                        x2: 0,
	                        y2: 1
	                    },
	                    stops: [
	                        [0, Highcharts.getOptions().colors[0]],
	                        [1, Highcharts.Color(Highcharts.getOptions().colors[0]).setOpacity(0).get('rgba')]
	                    ]
	                },
	                marker: {
	                    radius: 2
	                },
	                lineWidth: 1,
	                states: {
	                    hover: {
	                        lineWidth: 1
	                    }
	                },
	                threshold: null
	            }
	        },
	        series: [{
	            type: 'area',
	            name: '美元兑欧元',
	            data: data
	        }]
	    });
	});

	
	 $('#rubbish').highcharts({
	        chart: {
	            type: 'areaspline',
	        },
	        legend: {
	            layout: 'vertical',
	            align: 'left',
	            verticalAlign: 'top',
	            x: 150,
	            y: 100,
	            floating: true,
	            borderWidth: 1,
	            backgroundColor: (Highcharts.theme && Highcharts.theme.legendBackgroundColor) || '#FFFFFF'
	        },
	        xAxis: {
	            categories: [
	                '周一',
	                '周二',
	                '周三',
	                '周四',
	                '周五',
	                '周六',
	                '周日'
	            ],
	            plotBands: [{ // visualize the weekend
	                from: 4.5,
	                to: 6.5,
	                color: 'rgba(68, 170, 213, .2)'
	            }]
	        },
	        yAxis: {
	            title: {
	                text: '水果 单位'
	            }
	        },
	        tooltip: {
	            shared: true,
	            valueSuffix: ' 单位'
	        },
	        credits: {
	            enabled: false
	        },
	        plotOptions: {
	            areaspline: {
	                fillOpacity: 0.5
	            }
	        },
	        series: [{
	            name: '小张',
	            data: [3, 4, 3, 5, 4, 10, 12]
	        }, {
	            name: '小潘',
	            data: [1, 3, 4, 3, 3, 5, 4]
	        }]
	    });

	 var charth = Highcharts.chart('histogram', {
	        title: {
	            text: '图表变换'
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
	        charth.update({
	            chart: {
	                inverted: false,
	                polar: false
	            },
	        });
	    });
	    $('#inverted').click(function () {
	        // chart.update 支持全部属性动态更新
	        charth.update({
	            chart: {
	                inverted: true,
	                polar: false
	            },

	        });
	    });
	    $('#polar').click(function () {
	        charth.update({
	            chart: {
	                inverted: false,
	                polar: true
	            },
	        });
	    });
/*	var chart1 = new Highcharts.chart('pillar', {
        chart: {
            type: 'column'
        },
        title: {
            text: '2015年1月-5月，各浏览器的市场份额'
        },
        xAxis: {
            type: 'category'
        },
        yAxis: {
            title: {
                text: '总的市场份额'
            }
        },
        legend: {
            enabled: false
        },
        credits: {
            enabled: false
       },
        plotOptions: {
            series: {
                borderWidth: 0,
                dataLabels: {
                    enabled: true,
                    format: '{point.y:.1f}%'
                }
            }
        },
        tooltip: {
            headerFormat: '<span style="font-size:11px">{series.name}</span><br>',
            pointFormat: '<span style="color:{point.color}">{point.name}</span>: <b>{point.y:.2f}%</b> of total<br/>'
        },
        series: [{
            name: '浏览器品牌',
            colorByPoint: true,
            data: [{
                name: 'IE',
                y: 56.33,
                drilldown: 'Microsoft Internet Explorer'
            }, {
                name: 'Chrome',
                y: 24.03,
                drilldown: 'Chrome'
            }, {
                name: 'Firefox',
                y: 10.38,
                drilldown: 'Firefox'
            }, {
                name: 'Safari',
                y: 4.77,
                drilldown: 'Safari'
            }, {
                name: 'Opera',
                y: 0.91,
                drilldown: 'Opera'
            }, {
                name: 'Proprietary or Undetectable',
                y: 0.2,
                drilldown: null
            }]
        }],
        drilldown: {
            series: [{
                name: 'IE',
                id: 'IE',
                data: [
                    [
                        'v11.0',
                        24.13
                    ],
                    [
                        'v8.0',
                        17.2
                    ],
                    [
                        'v9.0',
                        8.11
                    ],
                    [
                        'v10.0',
                        5.33
                    ],
                    [
                        'v6.0',
                        1.06
                    ],
                    [
                        'v7.0',
                        0.5
                    ]
                ]
            }, {
                name: 'Chrome',
                id: 'Chrome',
                data: [
                    [
                        'v40.0',
                        5
                    ],
                    [
                        'v41.0',
                        4.32
                    ],
                    [
                        'v42.0',
                        3.68
                    ],
                    [
                        'v39.0',
                        2.96
                    ],
                    [
                        'v36.0',
                        2.53
                    ],
                    [
                        'v43.0',
                        1.45
                    ],
                    [
                        'v31.0',
                        1.24
                    ],
                    [
                        'v35.0',
                        0.85
                    ],
                    [
                        'v38.0',
                        0.6
                    ],
                    [
                        'v32.0',
                        0.55
                    ],
                    [
                        'v37.0',
                        0.38
                    ],
                    [
                        'v33.0',
                        0.19
                    ],
                    [
                        'v34.0',
                        0.14
                    ],
                    [
                        'v30.0',
                        0.14
                    ]
                ]
            }, {
                name: 'Firefox',
                id: 'Firefox',
                data: [
                    [
                        'v35',
                        2.76
                    ],
                    [
                        'v36',
                        2.32
                    ],
                    [
                        'v37',
                        2.31
                    ],
                    [
                        'v34',
                        1.27
                    ],
                    [
                        'v38',
                        1.02
                    ],
                    [
                        'v31',
                        0.33
                    ],
                    [
                        'v33',
                        0.22
                    ],
                    [
                        'v32',
                        0.15
                    ]
                ]
            }, {
                name: 'Safari',
                id: 'Safari',
                data: [
                    [
                        'v8.0',
                        2.56
                    ],
                    [
                        'v7.1',
                        0.77
                    ],
                    [
                        'v5.1',
                        0.42
                    ],
                    [
                        'v5.0',
                        0.3
                    ],
                    [
                        'v6.1',
                        0.29
                    ],
                    [
                        'v7.0',
                        0.26
                    ],
                    [
                        'v6.2',
                        0.17
                    ]
                ]
            }, {
                name: 'Opera',
                id: 'Opera',
                data: [
                    [
                        'v12.x',
                        0.34
                    ],
                    [
                        'v28',
                        0.24
                    ],
                    [
                        'v27',
                        0.17
                    ],
                    [
                        'v29',
                        0.16
                    ]
                ]
            }]
        }
    });*/
    
	var chart2 = new Highcharts.data({
        csv: document.getElementById('tsv').innerHTML,
        itemDelimiter: '\t',
        parsed: function (columns) {
            var brands = {},
                brandsData = [],
                versions = {},
                drilldownSeries = [];
            // 解析百分比字符串
            columns[1] = $.map(columns[1], function (value) {
                if (value.indexOf('%') === value.length - 1) {
                    value = parseFloat(value);
                }
                return value;
            });
            $.each(columns[0], function (i, name) {
                var brand,
                    version;
                if (i > 0) {
                    // Remove special edition notes
                    name = name.split(' -')[0];
                    // 拆分
                    version = name.match(/([0-9]+[\.0-9x]*)/);
                    if (version) {
                        version = version[0];
                    }
                    brand = name.replace(version, '');
                    //创建主数据
                    if (!brands[brand]) {
                        brands[brand] = columns[1][i];
                    } else {
                        brands[brand] += columns[1][i];
                    }
                    // 创建版本数据
                    if (version !== null) {
                        if (!versions[brand]) {
                            versions[brand] = [];
                        }
                        versions[brand].push(['v' + version, columns[1][i]]);
                    }
                }
            });
            $.each(brands, function (name, y) {
                brandsData.push({
                    name: name,
                    y: y,
                    drilldown: versions[name] ? name : null
                });
            });
            $.each(versions, function (key, value) {
                drilldownSeries.push({
                    name: key,
                    id: key,
                    data: value
                });
            });
            // 创建图例
            $('#pie').highcharts({
                chart: {
                    type: 'pie'
                },
                title: {
                    text: '2013年11月浏览器市场份额'
                },
                plotOptions: {
                    series: {
                        dataLabels: {
                            enabled: true,
                            format: '{point.name}: {point.y:.1f}%'
                        }
                    }
                },
                tooltip: {
                    headerFormat: '<span style="font-size:11px">{series.name}</span><br>',
                    pointFormat: '<span style="color:{point.color}">{point.name}</span>: <b>{point.y:.2f}%</b> of total<br/>'
                },
                credits: {
                    enabled: false
                },
                series: [{
                    name: '品牌',
                    colorByPoint: true,
                    data: brandsData
                }],
                drilldown: {
                    series: drilldownSeries
                }
            });
            $('#pie').highcharts({
                chart: {
                    plotBackgroundColor: null,
                    plotBorderWidth: null,
                    plotShadow: false
                },
                title: {
                    text: '2014 某网站上各个浏览器的访问量占比'
                },
                tooltip: {
                    headerFormat: '{series.name}<br>',
                    pointFormat: '{point.name}: <b>{point.percentage:.1f}%</b>'
                },
                plotOptions: {
                    pie: {
                        allowPointSelect: true,
                        cursor: 'pointer',
                        dataLabels: {
                            enabled: false
                        },
                        showInLegend: true
                    }
                },
                series: [{
                    type: 'pie',
                    name: '浏览器访问量占比',
                    data: [
                        ['Firefox',   45.0],
                        ['IE',       26.8],
                        {
                            name: 'Chrome',
                            y: 12.8,
                            sliced: true,
                            selected: true
                        },
                        ['Safari',    8.5],
                        ['Opera',     6.2],
                        ['其他',   0.7]
                    ]
                }]
            });
        }
    });
        
	var data = [
	            ['DE.SH', 728],
	            ['DE.BE', 710],
	            ['DE.MV', 963],
	            ['DE.HB', 541],
	            ['DE.HH', 622],
	            ['DE.RP', 866],
	            ['DE.SL', 398],
	            ['DE.BY', 785],
	            ['DE.SN', 223],
	            ['DE.ST', 605],
	            ['DE.NW', 237],
	            ['DE.BW', 157],
	            ['DE.HE', 134],
	            ['DE.NI', 136],
	            ['DE.TH', 704],
	            ['DE.', 361]
	        ];
	        $.getJSON("js/jiang_xi.geo.json", function (geojson) {
	            // Initiate the chart
	            Highcharts.mapChart('map', {
	                title: {
	                    text: 'GeoJSON in Highmaps'
	                },
	                mapNavigation: {
	                    enabled: true,
	                    buttonOptions: {
	                        verticalAlign: 'bottom'
	                    }
	                },
	                colorAxis: {
	                    tickPixelInterval: 100
	                },
	                credits: {
	                    enabled: false
	                },
	                series: [{
	                    data: data,
	                    mapData: geojson,
	                    joinBy: ['code_hasc', 0],
	                    keys: ['code_hasc', 'value'],
	                    name: 'Random data',
	                    states: {
	                        hover: {
	                            color: '#a4edba'
	                        }
	                    },
	                    dataLabels: {
	                        enabled: true,
	                        format: '{point.properties.postal}'
	                    }
	                }]
	            });
	        });
	
        $('#pillarrefush').click(function(){
        	
        	chart1.series[0].update({  
        		data: [5.0, 7.9, 5.5, 14.5, 18.2, 19.5, 25.2, {
                    y: 26.5,
                    marker: {
                        symbol: 'url(https://www.highcharts.com/demo/gfx/sun.png)'
                    }
                }, 25.3, 18.3, 3.9, 5.6]  
        	}); 
        	
        })
        
        
        var chart = Highcharts.chart('line', {
            yAxis: {
                title: {
                    text: '就业人数'
                }
            },
            legend: {
                layout: 'vertical',
                align: 'right',
                verticalAlign: 'middle'
            },
            plotOptions: {
                series: {
                    label: {
                        connectorAllowed: false
                    },
                    pointStart: 2010
                }
            },
            series: [{
                name: '安装，实施人员',
                data: [43934, 52503, 57177, 69658, 97031, 119931, 137133, 154175]
            }, {
                name: '工人',
                data: [24916, 24064, 29742, 29851, 32490, 30282, 38121, 40434]
            }, {
                name: '销售',
                data: [11744, 17722, 16005, 19771, 20185, 24377, 32147, 39387]
            }, {
                name: '项目开发',
                data: [null, null, 7988, 12169, 15112, 22452, 34400, 34227]
            }, {
                name: '其他',
                data: [12908, 5948, 8105, 11248, 8989, 11816, 18274, 18111]
            }],
            responsive: {
                rules: [{
                    condition: {
                        maxWidth: 500
                    },
                    chartOptions: {
                        legend: {
                            layout: 'horizontal',
                            align: 'center',
                            verticalAlign: 'bottom'
                        }
                    }
                }]
            }
        });
        
        
        $('#activity').highcharts({
            chart: {
                type: 'bar'
            },
            title: {
                text: '各洲不同时间的人口条形图'
            },
            subtitle: {
                text: '数据来源: Wikipedia.org'
            },
            xAxis: {
                categories: ['非洲', '美洲', '亚洲', '欧洲', '大洋洲'],
                title: {
                    text: null
                }
            },
            yAxis: {
                min: 0,
                title: {
                    text: '人口总量 (百万)',
                    align: 'high'
                },
                labels: {
                    overflow: 'justify'
                }
            },
            tooltip: {
                valueSuffix: ' 百万'
            },
            plotOptions: {
                bar: {
                    dataLabels: {
                        enabled: true,
                        allowOverlap: true
                    }
                }
            },
            legend: {
                layout: 'vertical',
                align: 'right',
                verticalAlign: 'top',
                x: -40,
                y: 100,
                floating: true,
                borderWidth: 1,
                backgroundColor: ((Highcharts.theme && Highcharts.theme.legendBackgroundColor) || '#FFFFFF'),
                shadow: true
            },
            credits: {
                enabled: false
            },
            series: [{
                name: '1800 年',
                data: [107, 31, 635, 203, 2]
            }, {
                name: '1900 年',
                data: [133, 156, 947, 408, 6]
            }, {
                name: '2008 年',
                data: [973, 914, 4054, 732, 34]
            }]
        });
        
        
        $('.exchange').click(function (){
        	if( !$('.rank').hasClass('rankmove') && !$('.rank').hasClass('rankback')){
        		$('.rank').addClass('rankmove');
        	}
        	else{
	        	if($('.rank').hasClass('rankback')){
	        		$('.rank').removeClass('rankback').addClass('rankmove');
	        	}
	        	else{
	        		$('.rank').removeClass('rankmove').addClass('rankback');
	        	}
        	}
        });
        
//        setInterval("$('.exchange').click()",8000);
        
        $('.rankRubbish .today').click(function(){
        	if($(this).hasClass('btn-warning')){
        		return;
        	}
        	var group = $('.rankRubbish .btn-group a');
        	for(var i = 0; i < group.length; i++){
        		if($(group[i]).hasClass('btn-warning'))
        			$(group[i]).removeClass('btn-warning').addClass('btn-danger');
        		$(this).removeClass('btn-danger').addClass('btn-warning');
        	}
        	
        	$.ajax({
    			type : "POST",
    			url : "rubbish_findTodayRank",
    			data : {
    				"date" : new Date()
    			},
    			success : function(data) {
    				var json = JSON.parse(data);
    				$('.rubbishranklist').empty();
    				for(var i = 0; i < json.length; i++){
    					var r = i + 1;
    					$('.rubbishranklist').append("<a class='list-group-item'> "+ r +".<span class='badge'>"+ json[i].sortKey +"kg</span> </i>&nbsp;&nbsp;&nbsp;"+ json[i].name +"&nbsp;&nbsp;<i class='fa fa-caret-up' style='color:red'></i></a>");
					}
    			}
    		});
        })
        
        $('.rankRubbish .thisweek').click(function(){
        	if($(this).hasClass('btn-warning')){
        		return;
        	}
        	var group = $('.rankRubbish .btn-group a');
        	for(var i = 0; i < group.length; i++){
        		if($(group[i]).hasClass('btn-warning'))
        			$(group[i]).removeClass('btn-warning').addClass('btn-danger');
        		$(this).removeClass('btn-danger').addClass('btn-warning');
        	}
        	$.ajax({
        		type : "POST",
        		url : "rubbish_findThisWeekRank",
        		data : {
        			"date" : new Date()
        		},
        		success : function(data) {
        			var json = JSON.parse(data);
        			$('.rubbishranklist').empty();
        			for(var i = 0; i < json.length; i++){
        				var r = i +1;
        				$('.rubbishranklist').append("<a class='list-group-item'> "+ r +".<span class='badge'>"+ json[i].sortKey +"kg</span> </i>&nbsp;&nbsp;&nbsp;"+ json[i].name +"&nbsp;&nbsp;<i class='fa fa-caret-up' style='color:red'></i></a>");
        			}
        		}
        	});
        })
        
        $('.rankRubbish .thismouth').click(function(){
        	if($(this).hasClass('btn-warning')){
        		return;
        	}
        	var group = $('.rankRubbish .btn-group a');
        	for(var i = 0; i < group.length; i++){
        		if($(group[i]).hasClass('btn-warning'))
        			$(group[i]).removeClass('btn-warning').addClass('btn-danger');
        		$(this).removeClass('btn-danger').addClass('btn-warning');
        	}
        	$.ajax({
        		type : "POST",
        		url : "rubbish_findThisMouthRank",
        		data : {
        			"date" : new Date()
        		},
        		success : function(data) {
        			var json = JSON.parse(data);
        			$('.rubbishranklist').empty();
        			for(var i = 0; i < json.length; i++){
        				var r = i +1;
        				$('.rubbishranklist').append("<a class='list-group-item'> "+ r +".<span class='badge'>"+ json[i].sortKey +"kg</span> </i>&nbsp;&nbsp;&nbsp;"+ json[i].name +"&nbsp;&nbsp;<i class='fa fa-caret-up' style='color:red'></i></a>");
        			}
        		}
        	});
        })
        
        $('.rankCommodity .today').click(function(){
        	if($(this).hasClass('btn-warning')){
        		return;
        	}
        	var group = $('.rankCommodity .btn-group a');
        	for(var i = 0; i < group.length; i++){
        		if($(group[i]).hasClass('btn-warning'))
        			$(group[i]).removeClass('btn-warning').addClass('btn-danger');
        		$(this).removeClass('btn-danger').addClass('btn-warning');
        	}
        	$.ajax({
        		type : "POST",
        		url : "commodity_findTodayRank",
        		data : {
        			"date" : new Date()
        		},
        		success : function(data) {
        			var json = JSON.parse(data);
        			$('.commodityranklist').empty();
        			for(var i = 0; i < json.length; i++){
        				var r = i +1;
        				$('.commodityranklist').append("<a class='list-group-item'> "+ r +".<span class='badge'>"+ json[i].sortKey +"件</span> </i>&nbsp;&nbsp;&nbsp;"+ json[i].name +"&nbsp;&nbsp;<i class='fa fa-caret-up' style='color:red'></i></a>");
        			}
        		}
        	});
        })
        $('.rankCommodity .thisweek').click(function(){
        	if($(this).hasClass('btn-warning')){
        		return;
        	}
        	var group = $('.rankCommodity .btn-group a');
        	for(var i = 0; i < group.length; i++){
        		if($(group[i]).hasClass('btn-warning'))
        			$(group[i]).removeClass('btn-warning').addClass('btn-danger');
        		$(this).removeClass('btn-danger').addClass('btn-warning');
        	}
        	$.ajax({
        		type : "POST",
        		url : "commodity_findThisWeekRank",
        		data : {
        			"date" : new Date()
        		},
        		success : function(data) {
        			var json = JSON.parse(data);
        			$('.commodityranklist').empty();
        			for(var i = 0; i < json.length; i++){
        				var r = i +1;
        				$('.commodityranklist').append("<a class='list-group-item'> "+ r +".<span class='badge'>"+ json[i].sortKey +"件</span> </i>&nbsp;&nbsp;&nbsp;"+ json[i].name +"&nbsp;&nbsp;<i class='fa fa-caret-up' style='color:red'></i></a>");
        			}
        		}
        	});
        })
        
        $('.rankCommodity .thismouth').click(function(){
        	if($(this).hasClass('btn-warning')){
        		return;
        	}
        	var group = $('.rankCommodity .btn-group a');
        	for(var i = 0; i < group.length; i++){
        		if($(group[i]).hasClass('btn-warning'))
        			$(group[i]).removeClass('btn-warning').addClass('btn-danger');
        		$(this).removeClass('btn-danger').addClass('btn-warning');
        	}
        	$.ajax({
        		type : "POST",
        		url : "commodity_findThisMouthRank",
        		data : {
        			"date" : new Date()
        		},
        		success : function(data) {
        			var json = JSON.parse(data);
        			$('.commodityranklist').empty();
        			for(var i = 0; i < json.length; i++){
        				var r = i +1;
        				$('.commodityranklist').append("<a class='list-group-item'> "+ r +".<span class='badge'>"+ json[i].sortKey +"件</span> </i>&nbsp;&nbsp;&nbsp;"+ json[i].name +"&nbsp;&nbsp;<i class='fa fa-caret-up' style='color:red'></i></a>");
        			}
        		}
        	});
        })
        
});