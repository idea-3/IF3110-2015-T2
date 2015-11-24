/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function(){
    //alert("test");
    // Menghentikan submit request
    $("#log-in-form").submit(function(e) {
       e.preventDefault(); 
    });
    
    // Memeriksa tombol submit di klik
    $("#log-in-submit").click(function(e){
        // Ambil form data secara serializable
        dataString = $("#log-in-form").serialize();
        
        // Ambil form data
        var email = $("#log-in-email").val();
        dataString = "email=" + email;
        var password = $("#log-in-password").val();
        dataString = "password=" + password;
        alert(email + password);
        
        // Buat AJAX request
        $.ajax({
           type: "POST",//4850
           url: "http://localhost:8081/Identity_Service/FrontEndTokenController",
           data: dataString,
           dataType: "json",
           // Hasil terima response dari server
           success: function(data, textStatus, jqXHR) {
               if (data.success) {
                $("#result").html("");
                $("#result").append("Token: " + data.access_token);
                $("#result").append("<br/>Lifetime: " + data.lifetime);
               } else {
                $("#result").html("Data is not valid");
                $("#result").append("Token: " + data.access_token);
                $("#result").append("<br/>Lifetime: " + data.lifetime);
                $("#result").append("<br/>Id: " + data.id_user);
               }
           },
           // Tidak ada response dari server
           error: function(jqXHR, textStatus, errorThrown) {
             console.log("Something really bad happened " + textStatus);
             $("#result").html(jqXHR.responseText);
           },
           beforeSend: function(jqXHR, settings) {
             // Menambah data dummy ke request
             settings.data += "&dummyData=whatever";
             $("#log-in-submit").attr("disabled", true);
           },
           complete: function(jqXHR, textStatus) {
             $("#log-in-submit").attr("disabled", false);
           }
        });
    });
});
