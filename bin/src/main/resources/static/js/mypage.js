$(document).ready(function(){

    $('ul.tabs li').click(function(){
        let tab_id = $(this).attr('data-tab');
        console.log(tab_id);
        $('ul.tabs li').removeClass('current');
        $('.tab-content').removeClass('current');

        $(this).addClass('current');
        $("#"+tab_id).addClass('current');
    })

});