$(function () {
    loadIndexIMG();
});


function loadIndexIMG() {
    $.ajax({
        dataType: 'json',
        url: '/getIndexIMG.form',
        success: function (data) {
            IndexIMGControl.run(data);
            console.log("AJAX SUCCESS!");
        }
    })
}

var count = 0;

var IndexIMGControl = {
    count : 0,
    imgPath : undefined,
    imgNum : 0,
    run : function (data) {
        this.imgPath = data;
        this.imgNum = data.length;
        this.animate();
        setInterval('IndexIMGControl.animate()',10000);
    },
    animate : function () {
        console.log(this.imgPath[count]);
        $('#background-pic').css({
            'background': 'url("/IMG/' + this.imgPath[count] + '") no-repeat fixed center',
            'animation': 'img-scale 10s linear infinite forwards ',
            'background-size':'cover'
        });
        count = (count + 1) % this.imgNum;
    }
};