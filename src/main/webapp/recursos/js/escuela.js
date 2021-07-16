$(document).ready(function () {
    listarEscuela();
});
var bandera;
function listarEscuela() {

    $.get("ec", {"opc": 1}, function (data) {
        var x = JSON.parse(data);
        $("#tablita tbody tr").remove();
        for (var i = 0; i < x.length; i++) {
            $("#tablita").append("<tr><td>" + (i + 1) + "</td><td>" + x[i].facultad + "</td><td>" + x[i].escuela + "</td><td><a href='#' onclick='editar(" + x[i].idescuela + ")'><i class='far fa-edit'></i></a></td><td><a href='#' onclick='del(" + x[i].idescuela + ")'><i class='fas fa-trash-alt'></i></a></td></tr>");
        }
    });
}
function agregar() {
    $("#myModal").modal('show');
}
function add() {
    bandera = $("#id").val();
    if (bandera=== 0) {
        var id = $("#id").val();
        var idfacu = $("#facultad").val();
        var escuela = $("#escuela").val();
        $.post("ec", {"idfacu": idfacu, "escuela": escuela, "opc": 2}, function (data) {
            listarEscuela();
            $("#myModal").modal('hide');
        });
    } else {
        alert("modificar");
        actualizar();
    }
}
function del(x) {
    alert(x);
    $.get("ec", {"idesc": x, "opc": 4}, function () {
        listarEscuela();
    });
}
function editar(x) {
    $.get("ec", {"opc": 5, "idesc": x}, function (data) {
        var x = JSON.parse(data);
        $("#escuela").val(x.nombre);
        $("#facultad").val(x.idfacultad);
        $("#id").val(x.idescuela);
    });
    $("#myModal").modal('show');
}

function actualizar(){
    var idesc = $("#id").val();
    var escuela = $("#escuela").val();
    var idfacu = $("#facultad").val();
    $.post("ec",{"idesc":idesc,"escuela":escuela, "idfacu":idfacu,"opc":3}, function () {
        listarEscuela();
        $("#id").val(0);
        bandera = 0;
    });
    alert($("#id").val());
    $("#myModal").modal('hide');
    
}
