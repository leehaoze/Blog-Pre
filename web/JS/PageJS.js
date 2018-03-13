$(function () {
    IndexIMGControl.run();
    InfoCard.run();

    var handle;
    window.addEventListener('popstate', function (event) {
        clearTimeout(handle);
        if (event.state != null) {
            var func = eval(event.state['html'] + '()');
        }
        else {
            $('#display-area>div').css({
                'top': 0,
                'transition': 'top 1600ms cubic-bezier(0.175, 0.885, 0.255, 1.12) 10ms'
            });
            handle = setTimeout(function () {
                $('#display-area').empty();
            }, 1600);
        }
    });
});


function loadName(blogername) {
    var name = blogername.text();
    var len = name.length;
    var size = 8 / len;
    var infocard = $('#info-card');
    var width = infocard.width();
    blogername.css({'font-size': '' + 4.5 * size * (width / 230) + 'em'});
}

//首页背景图片控制
var IndexIMGControl = {
    count: 0,           //图片叙述计数
    imgPath: undefined, //图片路径数组
    imgNum: 0,          //图片数量
    run: function () {  //执行函数
        $.ajax({
            dataType: 'json',
            url: '/getIndexIMG.form',
            success: function (data) {
                IndexIMGControl.imgPath = data;
                IndexIMGControl.imgNum = data.length;
                IndexIMGControl.animate();
                //鼠标移动特效
                $('#background-pic').mousemove(function (e) {
                    IndexIMGControl.move(e);
                });
                //每10s调用一次动画函数
                setInterval('IndexIMGControl.animate()', 10000);
            }
        })
    },
    animate: function () {
        $('#background-pic').css({
            'background': 'url(' + this.imgPath[this.count] + ') no-repeat fixed center',
            'animation': 'img-scale 10s linear infinite forwards ',
            'background-size': 'cover'
        });
        $('#info-card:after').css({
            'background': 'url(' + this.imgPath[this.count] + ') no-repeat fixed center',
            'animation': 'img-scale 10s linear infinite forwards ',
            'background-size': 'cover'
        });
        this.count = (this.count + 1) % this.imgNum;
    },
    pre_x: undefined,
    pre_y: undefined,
    //鼠标移动特效
    move: function (e) {
        var x = e.pageX;
        var y = e.pageY;
        if (this.pre_x != undefined && this.pre_y != undefined) {
            $('#background-container').css({
                'transform': 'translate(' + -(x - this.pre_x) / 100 + 'px,' + -(y - this.pre_y) / 100 + 'px)'
            });
            $('#info-card:after').css({
                'transform': 'translate(' + -(x - this.pre_x) / 100 + 'px,' + -(y - this.pre_y) / 100 + 'px)'
            });
        }
        else {
            this.pre_x = innerWidth / 2;
            this.pre_y = innerHeight / 2;
        }
    }
};

var InfoCard = {
    run: function () {
        InfoCard.loadInfo();
    },
    loadInfo: function () {
        $.ajax({
            dataType: 'json',
            url: '/getInfo.form',
            success: function (data) {
                InfoCard.writeData(data);
            }
        })
    },
    writeData: function (data) {
        $('#head-pic').css({
            'background': 'url(' + data['head_pic_path'] + ') no-repeat center',
            'background-size': 'cover'
        });
        var bloger_name = $('#bloger-name'), quoto = $('#quoto');
        bloger_name.text(data['bloger_name']);
        bloger_name.css('font-family', data['name_font']);
        quoto.text(data['quoto']);
        quoto.css('font-family', data['quoto_font']);
        // 名字自适应大小
        $(window).resize(function () {
            InfoCard.name_size_control(bloger_name)
        });
        var index = ["qq", "wechat", "github", "email", "blog"];
        var dict = {"qq": "QQ", "wechat": "WeChat", "github": "Github", "email": "Email", "blog": "Blog"};
        //设定宽度相关
        var effective_count = 0;
        for (var i = 0; i < index.length; ++i) {
            if (data[index[i]] != "none") {
                if (index[i] == "blog") {
                    $('#info-footer').append(
                        '<span id="' + index[i] + '-logo"><img src="IMG/' + dict[index[i]] + '-Logo.png"></span>'
                    );
                    $('#blog-logo').click(function () {
                        page_switch_control.load_blog_page(false);
                    });
                }
                else {
                    $('#info-footer').append(
                        '<span id="' + index[i] + '-logo"><a href="' + data[index[i]] + '"><img src="IMG/' + dict[index[i]] + '-Logo.png"></a></span>'
                    );
                }
                effective_count += 1;
            }
        }

        $('#info-footer').find('span>a>img').css('max-width', (effective_count * 20) > 80 ? (effective_count * 20) : 80 + '%');
        $('#info-footer').find('span>img').css('max-width', (effective_count * 20) > 80 ? (effective_count * 20) : 80 + '%');
    },
    name_size_control: function (blogername) {
        var name = blogername.text();
        var len = name.length;
        var size = 8 / len;
        var infocard = $('#info-card');
        var width = infocard.width();
        blogername.css({'font-size': '' + 4.5 * size * (width / 230) + 'em'});
    }
};


var page_switch_control = {
    load_blog_page: function (replay) {
        $('#display-area').load("/getDisplayArea.form", function () {
            var background_height = $('#background-color').height();
            $('#main-content').css({
                'top': '-' + (background_height + $('#info-card').height() - window.innerHeight * 0.02),
                'transition': 'top 1600ms cubic-bezier(0.175, 0.885, 0.255, 1.12) 10ms'
            });

            if (replay == false) {

                var state = {
                    url: window.document.location.href,
                    title: window.document.title,
                    html: 'page_switch_control.load_blog_page'
                };
                window.history.pushState(state, null, "http://localhost:8080/blog");
            }
        });
    }
};


var AJAX = {
    Url: "",
    Type: "",
    DataType: null,
    postdata: null,
    getdata: null,
    Get: function (Type, dataType, url, postdata, getdata) {
        this.ajaxSet(Type, dataType, url, postdata, getdata);
        $.ajax({
            url: this.Url,
            type: this.Type,
            contentType: "application/json; charset=utf-8",
            data: this.postdata,
            dataType: this.DataType,
            success: function (data) {
                this.getdata = data;
                console.log("Get Success USER");
                console.log(data);
            },
            error: function (data, textStatus, errorThrown) {
                console.log(data);
            }
        })
    },
    ajaxSet: function (Type, dataType, url, postdata, getdata) {
        this.Type = Type;
        this.DataType = dataType;
        this.Url = url;
        this.postdata = postdata;
        this.getdata = getdata;
    }

};