//javascript
var ADDCASE = ADDCASE || {};
var PROJECT = PROJECT || {};
var GROUP = GROUP || {};

ADDCASE.setMethod1 = function (id, v) {

    //alert($("#"+id).length);
    $("#" + id).each(function () {
        //alert($(this).text())
        $(this).attr('class', '');
        //$(this).removeClass("active");
    });
    //	$(id).each(function(){
    //    		alert($(this).text());
    //			alert($(this).attr("class"));
    //		});

    $(this).attr('class', 'active');
    alert($(this).attr('class'));
    alert($(this).tagName);
}


ADDCASE.setMethod2 = function (id) {
    var list = $("#" + id);
    for (var i = 0; i < list.length; i++) {

        list.attr('class', '');
        list[i].onclick = function () {
            alert($(this).text);
            $(this).attr('class', 'active');
        }
        debugger;
    }

}

ADDCASE.setMethod = function (e_id, event) {
    $(this).delegate("li", "click", function () {
        // "$(this)" is the node that was clicked
        //alert("you clicked a link!", $(this));
        alert($(this).text);
    });
}

/*ADDCASE.onclick = function (id) {
 　　var oUl = $("#" + id + " li");
 　　oUl.onclick = function (ev) {
 　　　　var ev = ev || window.event;
 　　　　var target = ev.target || ev.srcElement;
 　　　　if (target.nodeName.toLowerCase() == 'li') {
 alert(123);
 alert(target.innerHTML);
 　　　　}
 　　}
 }
 */
ADDCASE.changeMethod = function (id) {
    $(id)[0].onclick = function (e) {
        if (e.target && e.target.nodeName.toUpperCase() === 'A') {
            var elems = $(id + '>li');
            elems.map(function (index, value) {
                $(value).removeClass('active');
            });
            $(e.target).parent().attr('class', 'active');
        }
    }
}
ADDCASE.changeMethodButtonToPrimary = function (id) {
    $(id).onclick = function (e) {
        if (e.target && e.target.nodeName.toUpperCase() === 'INPUT') {
            var elems = $(id + '>label');
            elems.map(function (index, value) {
                $(value).removeClass('active', 'btn btn-default');
            });
            debugger;
            $(e.target).parent().attr('class', 'btn btn-primary active');
        }
    }
}

ADDCASE.changeTestModelDisplay = function (id) {
    $(id).attr('style', '');
}

ADDCASE.changeTestModelHidden = function (id) {
    $(id).attr('style', 'display:none');
}

ADDCASE.changeTestModelHidden_duo = function () {

    $('#CheckKey').attr('style', 'display:none');
    $('#selectCheckType').attr('style', 'display:none');
    $('#CheckErrorMassage').attr('style', 'display:none');
    $('#CheckCode').attr('style', 'display:none');


}

ADDCASE.changeTestModelDisplay_duo = function () {

    $('#CheckKey').attr('style', '');
    $('#selectCheckType').attr('style', '');
    $('#CheckErrorMassage').attr('style', '');
    $('#CheckCode').attr('style', '');


}

ADDCASE.setInputApi = function (id_1, id_2) {

    $(id_1).attr('style', '');
    $(id_2).attr('style', 'display:none');
}

PROJECT.showByPath = function (ids) {

    var id=ids.split(",");
    for (var i=0;i<id.length;i++)
    {
        $(id[i]).attr('style', '');

    }
    /**
    $(id1).attr('style', '');
    $(id2).attr('style', '');
    $(id3).attr('style', '');
    */
}

PROJECT.hiddenByPath = function (ids) {
    var id=ids.split(",");
    for (var i=0;i<id.length;i++)
    {
        $(id[i]).attr('style', 'display:none');
    }

}

GROUP.changeModalWordToAdd = function (id_1, id_2) {
    $(id_1).text('新建组');
    $(id_2).text('新建');
}
GROUP.changeModalWordToUpdate = function (id_1, id_2) {
    $(id_1).text('编辑组');
    $(id_2).text('更改');
}