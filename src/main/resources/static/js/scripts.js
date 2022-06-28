// toggle play & pause button on carousel
$(function () {
    $(".carousel").carousel({ interval: 2000 });
    $("#carouselButton").click(function () {
        if ($("#carouselButton").children("i").hasClass("fa-pause")) {
            $(".carousel").carousel("pause");
            $("#carouselButton").children("i").removeClass("fa-pause");
            $("#carouselButton").children("i").addClass("fa-play");
        } else {
            $(".carousel").carousel("cycle");
            $("#carouselButton").children("i").removeClass("fa-play");
            $("#carouselButton").children("i").addClass("fa-pause");
        }
    });


// show or hide modals
//     $("#reserveButton").click(function(){
//         $('#reserveModal').modal('show');
//     });

    $("#loginButton").click(function(){
        $('#loginModal').modal('show');
    });

});

//  file upload
function readURL(input){
    if (input.files && input.files[0]) {
        const reader = new FileReader();
        reader.onload = function(e) {
            $('#imgPreview').attr('src', e.target.result).width(100).height(100);
        }
        reader.readAsDataURL(input.files[0])
    }
}

$('#productImage').change(function(){
    readURL(this);
});
$(".custom-file-input").on("change", function(){
    let fileName = $(this).val().split("\\").pop();
    $(this).siblings(".custom-file-label").addClass("selected").html(fileName);
});

// function dropDown() {
//     document.getElementById("myDropdown").classList.toggle("show");
// }
//
// // Close the dropdown menu if the user clicks outside of it
// // IF-STATMENTS, LOOPS, VARIABLES, FUNCTION, EVENT
// window.onclick = function(event) {
//     if (!event.target.matches('.dropbtn')) {
//         let dropdowns = document.getElementsByClassName("dropdown-content");
//         let i;
//         for (i = 0; i < dropdowns.length; i++) {
//             let openDropdown = dropdowns[i];
//             if (openDropdown.classList.contains('show')) {
//                 openDropdown.classList.remove('show');
//             }
//         }
//     }
// }