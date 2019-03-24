function loadUser() {
    $.ajax('./getUser', {
        method: 'get',
        dataType: "json",
        success: function (data) {
            if (data == null) {
                document.getElementById("login").innerHTML = "<a href='login.html' style='float: right; padding-top: 10px'>Войти</a>";
            } else {
                document.getElementById("login").innerHTML = "<a href='login.html' style='float: right; padding-top: 10px'>" + data.login + "  Выйти</a>";
            }
        }
    })
}

function checkUser() {
    $.ajax('./getUser', {
        method: 'get',
        dataType: "json",
        success: function (data) {
            if (data == null) {
                location.href = "./login.html";
            } else {
                location.href = "./newElement.html";
            }
        }
    })
}

function getOrdersUsers() {
    var userId = getUserId();
    $.ajax('./getOrders', {
        method: 'get',
        dataType: "json",
        success: function (data) {
            document.getElementById("orders").innerHTML = "";
            $.each(data, function (i, el) {
                var line = "<tr>"
                    + "<td>" + el.car.model.brand.name + "</td>"
                    + "<td>" + el.car.model.name + "</td>"
                    + "<td>" + el.car.color + "</td>"
                    + "<td>" + el.car.year + "</td>"
                    + "<td>" + el.description + "</td>"
                    + "<td>" + el.price + "</td>"
                    + "<td>" + new Date(el.date) + "</td>"
                    + "<td>" + el.user.login + "</td>";
                if (userId != null && userId == el.user.id) {
                    if (el.sold === true) {
                        line += "<td style='text-align: center'>" +
                            "<input type='checkbox' checked onchange='return updateStatus("+el.id+","+ el.sold+")'/></td></tr>";
                    } else {
                        line += "<td style='text-align: center'>" +
                            "<input type='checkbox' onchange='return updateStatus("+el.id+","+ el.sold+")'/></td></tr>";
                    }
                } else {
                    if (el.sold === true) {
                        line += "<td>sold</td></tr>";
                    } else {
                        line += "<td>for sale</td></tr>";
                    }
                }
                document.getElementById("orders").innerHTML += line;
            });
        }
    })
}

function validate() {
    $.ajax('./json', {
        method : 'post',
        data : {
            login : $('#login').val(),
            password : $('#password').val()
        },
        complete : function(data){
            var result = JSON.parse(data.responseText);
            if (result) {
                location.href = "index.html";
            } else {
                alert("Please input correct login");
            }
        }
    });
    return false;
}

function setPriceFilter() {
    $.ajax('./setPriceFilter', {
        method: 'post',
        data: {
            'filter': 'true',
            'price': $('#priceToSet').val()
        },
        success: location.reload()
    })
}

function resetPriceFilter() {
    $.ajax('./setPriceFilter', {
        method: 'post',
        data: {
            'filter': 'false',
            'price': 0
        },
        success: location.reload()
    })
}

function workSelector() {
    brandSelector();
    engineSelector();
    transmissionSelector();
    carBodiesSelector();
    drivesSelector();
}

function brandSelector() {
    $.ajax('./getBrands', {
        method: 'get',
        dataType: "json",
        success: function (data) {
            $.each(data, function (i, el) {
                document.getElementById("brand").innerHTML += "<option value='" + el.id + "'>" + el.name + "</option>";
            });
        }
    })
}

function modelSelector() {
    var sel = document.getElementById("brand");
    $.ajax('./getModels', {
        method: 'get',
        data : {
            brand : sel.options[sel.selectedIndex].text
        },
        dataType: "json",
        success: function (data) {
            document.getElementById("model").innerHTML = "";
            $.each(data, function (i, el) {
                document.getElementById("model").innerHTML += "<option value='" + el.id + "'>" + el.name + "</option>";
            });
        }
    })
}

function engineSelector() {
    $.ajax('./getEngines', {
        method: 'get',
        dataType: "json",
        success: function (data) {
            $.each(data, function (i, el) {
                document.getElementById("engine").innerHTML += "<option value='" + el.id + "'>" + el.name + "</option>";
            });
        }
    })
}

function transmissionSelector() {
    $.ajax('./getTransmissions', {
        method: 'get',
        dataType: "json",
        success: function (data) {
            $.each(data, function (i, el) {
                document.getElementById("transmission").innerHTML += "<option value='" + el.id + "'>" + el.name + "</option>";
            });
        }
    })
}

function carBodiesSelector() {
    $.ajax('./getBodies', {
        method: 'get',
        dataType: "json",
        success: function (data) {
            $.each(data, function (i, el) {
                document.getElementById("body").innerHTML += "<option value='" + el.id + "'>" + el.name + "</option>";
            });
        }
    })
}

function drivesSelector() {
    $.ajax('./getDrives', {
        method: 'get',
        dataType: "json",
        success: function (data) {
            $.each(data, function (i, el) {
                document.getElementById("drive").innerHTML += "<option value='" + el.id + "'>" + el.name + "</option>";
            });
        }
    })
}

function addNewOrder() {
    var selBrand = document.getElementById("brand");
    var selModel = document.getElementById("model");
    var selBody = document.getElementById("body");
    var selEngine = document.getElementById("engine");
    var selTransmission = document.getElementById("transmission");
    var selDrive = document.getElementById("drive");
    $.ajax('./addOrder', {
        method : 'post',
        data : {
            price : $('#price').val(),
            year : $('#year').val(),
            description : $('#description').val(),
            color : $('#color').val(),
            enginePower : $('#enginePower').val(),
            mileage : $('#mileage').val(),
            modelId : selModel.options[selModel.selectedIndex].value,
            transmissionId : selTransmission.options[selTransmission.selectedIndex].value,
            engineId : selEngine.options[selEngine.selectedIndex].value,
            bodyId : selBody.options[selBody.selectedIndex].value,
            driveId : selDrive.options[selDrive.selectedIndex].value
        },
        complete : function(data){
            location.href = "./index.html";
        }
    });
}

function getUserId() {
    var result = null;
    $.ajax('./getUser', {
        method: 'get',
        async: false,
        dataType: "json",
        success: function (data) {
            if (data != null) {
                result = data.id;
            }
        }
    });
    return result;
}

function updateStatus(id, status) {
    $.ajax('./updateStatus', {
        method: 'post',
        data: {
            'id': id,
            'isSold': status
        }
    })
}