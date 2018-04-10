function doCharts() {
    require.config({
        paths: {
            echarts: './../maplib'
        }

    });

    require(
        [
            'echarts',
            'echarts/chart/map' // 使用地图，按需加载
        ],
        function(ec) {
            //网络设备事件趋势
            var myChart = ec.init(document.getElementById('mapChart'));

            var ecConfig = require('echarts/config');
            var path = "../maplib/resource/geoJson";
            require('echarts/util/mapData/params').params.天津市 = {
                getGeoJson: function(callback) {
                    $.getJSON(path + '/' + '天津市.json', function(data) {
                        callback(require('echarts/util/mapData/params').decode(data));
                    });
                }
            };


            option = {
                backgroundColor: '#white',
                color: ['gold', 'aqua', 'lime'],
                /*tooltip : {
                    trigger: 'item',
                    formatter: '{b}'
                },*/
                legend: {
                    orient: 'vertical',
                    x: 'left',
                    data: ['管控中心', '用户'],
                    selectedMode: 'single',
                    selected: {
                        '管控中心': true,
                        '用户': false
                    },
                    textStyle: {
                        color: '#fff'
                    }
                },
                toolbox: {
                    show: true,
                    orient: 'vertical',
                    x: 'right',
                    y: 'center',
                    feature: {
                        mark: {
                            show: true
                        },
                        dataView: {
                            show: true,
                            readOnly: false
                        },
                        restore: {
                            show: true
                        },
                        saveAsImage: {
                            show: true
                        }
                    }
                },
                dataRange: {
                    min: 0,
                    max: 100,
                    calculable: true,
                    color: ['#ff3333', 'orange', 'yellow', 'lime', 'aqua'],
                    textStyle: {
                        color: '#fff'
                    }
                },
                series: [{
                    name: '天津市',

                    type: 'map',
                    //禁止地图缩放
                    roam: false,
                    hoverable: false,
                    mapType: '天津',
                    clickable: false,
                    itemStyle: {


                    },
                    // roam:false,
                    itemStyle: {
                        normal: {
                            label: {
                                show: true,
                                textStyle: {
                                    color: 'white'
                                }
                            },
                            borderColor: 'rgba(100,149,137,1)',
                            borderWidth: 0.5,
                            areaStyle: {
                                color: 'skyblue'
                            }
                        },
                        emphasis: {
                            areaColor: 'rgba(27,168,198,0.9)',
                            borderColor: 'rgb(0,0,0,0.8)',
                            borderWidth: '0',
                            shadowColor: 'black',
                            shadowOffsetX: 10,
                            shadowOffsetY: -10,
                            shadowBlur: 10,
                            label: {
                                show: true,
                                textStyle: {
                                    color: 'white',
                                    fontSize: 15
                                }
                            }
                        }
                    },

                    data: [{
                            name: '蓟县'
                        }, {
                            name: '武清区'
                        }, {
                            name: '宝坻区'
                        },
                        //{name:'宝坻区',value:65},选中用
                        {
                            name: '静海县'
                        }, {
                            name: '宁河县'
                        }, {
                            name: '大港区'
                        }, {
                            name: '西青区'
                        }, {
                            name: '塘沽区'
                        }, {
                            name: '北辰区'
                        }, {
                            name: '东丽区'
                        }, {
                            name: '汉沽区'
                        }, {
                            name: '津南区'
                        },
                        //{name:'河西区',value:10},
                        //{name:'河东区',value:10},
                        //{name:'南开区',value:10},
                        //{name:'河北区',value:10},
                        //{name:'红桥区',value:10},
                        {
                            name: '和平区'
                        }
                    ],
                    markLine: {
                        smooth: true,
                        symbol: ['none', 'circle'],
                        symbolSize: 1,
                        itemStyle: {
                            normal: {
                                color: '#fff',
                                borderWidth: 1,
                                borderColor: 'rgba(30,144,255,0.5)'
                            }
                        },
                        data: [
                            [{
                                name: '蓟县'
                            }, {
                                name: '大港区'
                            }],
                            [{
                                name: '武清区'
                            }, {
                                name: '大港区'
                            }],
                            [{
                                name: '宝坻区'
                            }, {
                                name: '大港区'
                            }],
                            [{
                                name: '静海县'
                            }, {
                                name: '大港区'
                            }],
                            [{
                                name: '宁河县'
                            }, {
                                name: '大港区'
                            }],
                            [{
                                name: '西青区'
                            }, {
                                name: '大港区'
                            }],
                            [{
                                name: '塘沽区'
                            }, {
                                name: '大港区'
                            }],
                            [{
                                name: '北辰区'
                            }, {
                                name: '大港区'
                            }],
                            [{
                                name: '东丽区'
                            }, {
                                name: '大港区'
                            }],
                            [{
                                name: '汉沽区'
                            }, {
                                name: '大港区'
                            }],
                            [{
                                name: '津南区'
                            }, {
                                name: '大港区'
                            }],
                            // [{name:'大港区'},{name:'河东区'}],
                            //[{name:'大港区'},{name:'河西区'}],
                            //[{name:'大港区'},{name:'南开区'}],
                            //[{name:'大港区'},{name:'河北区'}],
                            //[{name:'大港区'},{name:'红桥区'}],
                            [{
                                name: '和平区'
                            }, {
                                name: '大港区'
                            }]

                        ],
                    },
                    geoCoord: {

                        '蓟县': [117.4672, 40.104],
                        '武清区': [117.0621, 39.4121],
                        '宝坻区': [117.4274, 39.5913],
                        '静海县': [116.9824, 38.8312],
                        '宁河县': [117.6801, 39.3853],
                        '西青区': [117.1829, 39.0022],
                        '塘沽区': [117.6801, 38.9987],
                        '北辰区': [117.1761, 39.2548],
                        '东丽区': [117.4013, 39.1223],
                        '汉沽区': [117.8888, 39.2191],
                        '津南区': [117.3958, 38.9603],
                        //'河西区': [117.2365,39.0804],
                        //'河东区': [117.2571,39.1209],
                        //'南开区': [117.1527,39.1065],
                        //'河北区': [117.2145,39.1615],
                        //'红桥区': [117.1596,39.1663],
                        '和平区': [117.2008, 39.1189],
                        '管控中心': [117.2108, 39.2189],
                        '大港区': [117.3875, 38.757]
                    }
                }, {
                    name: '管控中心',
                    type: 'map',
                    mapType: '天津',
                    data: [],
                    markLine: {
                        smooth: true,
                        effect: {
                            show: true,
                            scaleSize: 1,
                            period: 30,
                            color: '#fff',
                            shadowBlur: 10
                        },
                        itemStyle: {
                            normal: {
                                borderWidth: 1,
                                lineStyle: {
                                    type: 'solid',
                                    shadowBlur: 10
                                }
                            }
                        },
                        data: [
                            [{
                                name: '蓟县'
                            }, {
                                name: '大港区',
                                value: 88
                            }],
                            [{
                                name: '武清区'
                            }, {
                                name: '大港区',
                                value: 76
                            }],
                            [{
                                name: '宝坻区'
                            }, {
                                name: '大港区',
                                value: 21
                            }],
                            [{
                                name: '静海县'
                            }, {
                                name: '大港区',
                                value: 10
                            }],
                            [{
                                name: '宁河县'
                            }, {
                                name: '大港区',
                                value: 22
                            }],
                            [{
                                name: '西青区'
                            }, {
                                name: '大港区',
                                value: 23
                            }],
                            [{
                                name: '塘沽区'
                            }, {
                                name: '大港区',
                                value: 24
                            }],
                            [{
                                name: '北辰区'
                            }, {
                                name: '大港区',
                                value: 25
                            }],
                            [{
                                name: '东丽区'
                            }, {
                                name: '大港区',
                                value: 26
                            }],
                            [{
                                name: '汉沽区'
                            }, {
                                name: '大港区',
                                value: 27
                            }],
                            [{
                                name: '津南区'
                            }, {
                                name: '大港区',
                                value: 28
                            }],
                            [{
                                name: '和平区'
                            }, {
                                name: '大港区',
                                value: 29
                            }]
                        ]
                    },
                    markPoint: {
                        symbol: 'emptyCircle',
                        symbolSize: function(v) {
                            return 10 + v / 10
                        },
                        effect: {
                            show: true,
                            shadowBlur: 0
                        },
                        itemStyle: {
                            normal: {
                                label: {
                                    show: false
                                }
                            },
                            emphasis: {
                                label: {
                                    position: 'top'
                                }
                            }
                        },
                        data: [{
                                name: '蓟县',
                                value: 0
                            }, {
                                name: '武清区',
                                value: 0
                            }, {
                                name: '宝坻区',
                                value: 0
                            }, {
                                name: '静海县',
                                value: 0
                            }, {
                                name: '宁河县',
                                value: 0
                            }, {
                                name: '大港区',
                                value: 0
                            }, {
                                name: '西青区',
                                value: 0
                            }, {
                                name: '塘沽区',
                                value: 0
                            }, {
                                name: '北辰区',
                                value: 0
                            }, {
                                name: '东丽区',
                                value: 0
                            }, {
                                name: '汉沽区',
                                value: 0
                            }, {
                                name: '津南区',
                                value: 0
                            },
                            //{name:'河西区',value:0},
                            //{name:'河东区',value:0},
                            //{name:'南开区',value:0},
                            //{name:'河北区',value:0},
                            //{name:'红桥区',value:0},
                            {
                                name: '和平区',
                                value: 0
                            }
                        ]
                    }
                }, {
                    name: '用户',
                    type: 'map',
                    mapType: '天津',
                    data: [],
                    markLine: {
                        smooth: true,
                        effect: {
                            show: true,
                            scaleSize: 1,
                            period: 30,
                            color: '#fff',
                            shadowBlur: 10
                        },
                        itemStyle: {
                            normal: {
                                borderWidth: 1,
                                lineStyle: {
                                    type: 'solid',
                                    shadowBlur: 10
                                }
                            }
                        },
                        data: [
                            //[{name:'河东区'}, {name:'东丽区',value:95}],
                            //[{name:'河东区'}, {name:'和平区',value:90}],
                            //[{name:'河东区'}, {name:'红桥区',value:20}],
                            // [{name:'河东区'}, {name:'宝坻区',value:10}]
                        ]
                    },
                    markPoint: {
                        symbol: 'emptyCircle',
                        symbolSize: function(v) {
                            return 10 + v / 10
                        },
                        effect: {
                            show: true,
                            shadowBlur: 0
                        },
                        itemStyle: {
                            normal: {
                                label: {
                                    show: false
                                }
                            },
                            emphasis: {
                                label: {
                                    position: 'top'
                                }
                            }
                        },
                        data: [{
                            name: '蓟县',
                            value: 6
                        }, {
                            name: '武清区',
                            value: 2
                        }, {
                            name: '宝坻区',
                            value: 0
                        }, {
                            name: '静海县',
                            value: 0
                        }, {
                            name: '宁河县',
                            value: 0
                        }, {
                            name: '大港区',
                            value: 0
                        }, {
                            name: '西青区',
                            value: 0
                        }, {
                            name: '塘沽区',
                            value: 0
                        }, {
                            name: '北辰区',
                            value: 0
                        }, {
                            name: '东丽区',
                            value: 0
                        }, {
                            name: '汉沽区',
                            value: 0
                        }, {
                            name: '津南区',
                            value: 0
                        }, {
                            name: '河西区',
                            value: 0
                        }, {
                            name: '河东区',
                            value: 0
                        }, {
                            name: '南开区',
                            value: 0
                        }, {
                            name: '河北区',
                            value: 0
                        }, {
                            name: '红桥区',
                            value: 0
                        }, {
                            name: '和平区',
                            value: 0
                        }]
                    }
                }]
            };

            var ecConfig = require('echarts/config');
            myChart.on(ecConfig.EVENT.CLICK, function(params) {
                var serverIP = location.protocol + "//" + location.hostname + ":" + location.port;
                var url = "";
                //   	alert("****"+params.data.name+params.data.value+"*****");

                if (params.data.name == '宝坻区')
                    windowTitle = '大众汽车';
                else
                    windowTitle = '天津一厂';

                xp = parseFloat(params.data.x / $("#mapChart").width() * 100).toFixed(0);
                yp = parseFloat(params.data.y / $("#mapChart").height() * 100).toFixed(0);
                if (yp > 70)
                    yp = yp - 20;
                xp = xp + '%';
                yp = yp + '%';


                layer.open({
                    type: 1,
                    title: windowTitle,
                    area: ['200px', '260px'],
                    //    offset: ['50%', '50%'],  //如果想居中，可以注释掉这一行
                    //     offset: [yp,xp],  //如果想居中，可以注释掉这一行
                    shadeClose: false, //点击遮罩关闭
                    anim: 3,
                    //      maxmin:true,
                    content: '<div class="layui-anim-rotate"><table  style="position:absolute;left:20%;width:80%;height:99%;color:white"><tr><td style="aligh:right"><img src="images/drop.png" style="width:24px;height:36px"></img></td><td>789&nbspt</td></tr>' +
                        '<tr><td style="aligh:right"><img src="images/power.png" style="width:24px;height:32px"></img></td><td>13423&nbspkWh</td></tr>' +
                        '<tr><td style="aligh:right"><img src="images/gas.png" style="width:28px;height:32px"></img></td><td>1345&nbspm<sup>2</sup></td></tr>' +
                        '<tr><td style="aligh:right"><img src="images/temp.png" style="width:28px;height:36px"></img></td><td>76&nbsp℃</td></tr>' +
                        '</table></div>'
                });

            });

            myChart.setOption(option);



        }
    );
}