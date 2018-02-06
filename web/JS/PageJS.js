$(function () {
    IndexIMGControl.run();
    InfoCard.run();
    loadName();
});

function loadName() {
    var name = $('#bloger-name').text();
    var len = name.toString().length;
    var size = 8 / len;
    console.log(name.toString());
    $('#bloger-name').css({'font-size': '' + 4.5 * size + 'em'});
}

var IndexIMGControl = {
    count: 0,
    imgPath: undefined,
    imgNum: 0,
    run: function () {
        $.ajax({
            dataType: 'json',
            url: '/getIndexIMG.form',
            success: function (data) {
                IndexIMGControl.imgPath = data;
                IndexIMGControl.imgNum = data.length;
                IndexIMGControl.animate();
                $('#background-pic').mousemove(function (e) {
                    IndexIMGControl.move(e);
                });
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
        this.count = (this.count + 1) % this.imgNum;
    },
    pre_x: undefined,
    pre_y: undefined,
    move: function (e) {
        var x = e.pageX;
        var y = e.pageY;
        if (this.pre_x != undefined && this.pre_y != undefined) {
            $('#background-container').css({
                'transform': 'translate(' + -(x - this.pre_x) / 100 + 'px,' + -(y - this.pre_y) / 100 + 'px)'
            })
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
        console.log("Get INFO Success");
    },
    loadInfo: function () {
        $.ajax({
            dataType: 'json',
            url: '/getInfo.form',
            success: function (data) {
                InfoCard.writeData(data);
                console.log("GetInfo SUCCESS");
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

        var index = ["qq", "wechat", "github", "email", "blog"];
        var dict = {"qq":"QQ","wechat":"WeChat","github":"Github","email":"Email","blog":"Blog"};
        var effective_count = 0;
        for (var i = 0; i < index.length; ++i) {
            if (data[index[i]] != "none") {
                $('#info-footer').append(
                    '<span id="'+index[i]+'-logo"><a href="'+data[index[i]]+'"><img src="IMG/'+dict[index[i]]+'-Logo.png"></a></span>'
                );
                effective_count += 1;
            }
        }

        $('#info-footer').find('span>a>img').css('max-width', (effective_count * 20) > 80 ? (effective_count * 20) : 80 + '%');

    }
};