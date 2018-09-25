function showItems() {
    $.ajax('./showItems', {
        method : 'get',
        dataType : "json",
        data: {
            'isDone': $("#status").prop('checked')
        },
        success: function(data) {
            document.getElementById("items").innerHTML += "";
            $.each(data, function(i, el) {
                 var line = "<tbody><tr>"
                    + "<td>" + el.id + "</td>"
                    + "<td>" + el.description + "</td>"
                    + "<td>" + new Data(el.createDate) + "</td>";
                if (el.done === true) {
                    line += "<td style='text-align: center'>"
                        + "<input type='checkbox' checked onchange='return updateStatus("+el.id+","+ el.done+")'/></td>";
                } else {
                    line += "<td style='text-align: center'>"
                        + "<input type='checkbox' onchange='return updateStatus("+el.id+","+ el.done+")'/></td>";
                }
                line += "<td><button class='btn btn-default btn-xs' style='border: none; color: red'"
                    + "onclick='return deleteItem("+el.id+")'>"
                    + "<i class=\"glyphicon glyphicon-remove\"></i></button></td></tr>";
                document.getElementById("items").innerHTML += line;
            });
        }
    });
}

function addItem() {
    $.ajax('./addItem', {
        method : 'post',
        data : {
            'description' : $("#description").val()
        },
        success : location.reload()
    });
}

function updateStatus(id, status) {
    $.ajax('./updateStatus', {
        method : 'post',
        data : {
            'id' : id,
            'isDone' : status
        }
    });
}

function deleteItem() {
    $.ajax('./deleteItem', {
        method: 'post',
        data: {
            'id': id
        },
        success: location.reload()
    })
}