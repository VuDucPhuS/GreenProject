

    document.getElementById("menu_main_1").click(function() {
        document.getElementsByClassName("tab_hidden1").slideToggle("slow");
    })
    document.getElementById("header_menu_tab").click(function() {
        document.getElementsByClassName("header_menu_query").css("right", "0%");
    })
    document.getElementById("x_close_header_menu_query").click(function() {
        document.getElementsByClassName("header_menu_query").css("right", "-100%");
    })
    document.getElementById("menu_main_2").click(function() {
        document.getElementsByClassName("tab_hidden2").slideToggle("slow");
    })
    document.getElementById("tab1").onmousedown(function() {
        document.getElementsByClassName("sub_tab_1").css("right", "0");
    }, function() {
        document.getElementsByClassName("sub_tab_1").css("right", "-45%", "transition", "30s");
    }, )
    document.getElementsByClassName("sub_tab_1").onmousedown(function() {
        document.getElementsByClassName("sub_tab_1").css("right", "0");
    }, function() {
        document.getElementsByClassName("sub_tab_1").css("right", "-45%");
    }, )
    document.getElementById("tab2").mousedown(function() {
        document.getElementsByClassName("sub_tab_2").css("right", "0");
    })
    document.getElementById("tab2").mouseup(, function() {
    document.getElementsByClassName("sub_tab_2").css("right", "-45%");
    })
/*
    document.getElementsByClassName("sub_tab_2").onmousedown(function() {
        document.getElementsByClassName("sub_tab_2").css("right", "0");
    }, function() {
        document.getElementsByClassName("sub_tab_2").css("right", "-45%");
    }, )
    document.getElementById("tab3").onmousedown(function() {
        document.getElementsByClassName("sub_tab_3").css("right", "0");
    }, function() {
        document.getElementsByClassName("sub_tab_3").css("right", "-45%", "transition", "30s");
    }, )
    document.getElementsByClassName("sub_tab_3").onmousedown(function() {
        document.getElementsByClassName("sub_tab_3").css("right", "0");
    }, function() {
        document.getElementsByClassName("sub_tab_3").css("right", "-45%");
    }, )
*/

