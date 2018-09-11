var age = document.getElementById("age");
var email = document.getElementById("email");
var firstName = document.getElementById("firstName");
var password = document.getElementById("password");
var form = document.getElementById("pform");

	// function submitStuff() {
	// 	document.getElementById("button").addEventListener("click", function() {
	// 		var request = new XMLHttpRequest();
    //         var json = JSON.stringify({
    //             age: age,
    //             email: email,
    //             firstName: firstName,
    //             password: password
    //         });
	// 		request.open("post", 'localhost:8080/servlet2', true);
	// 		request.setRequestHeaders('Content-Type', 'application/json; charset=utf-8');
	// 		request.send(json);
	// 		request.onreadystatechange = function() {
	// 			if (request.readyState == 4 && request.status == 200) {
	// 			    getProjects();
	// 			}
	// 		};
	// 	});
    //
	// }

    // var form = document.getElementById("pform");
    // var newProjectName = document.getElementById("new-project-name");
    // var newProjectDesc = document.getElementById("new-project-desc");
     var projectsTable = document.getElementById("jstable");
    // var header = document.querySelector("header");

    function getProjects(){
        var xhr = new XMLHttpRequest();
        xhr.open('GET', 'http://localhost:8080/servlet2', true);
        xhr.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');
        xhr.send();
        xhr.onreadystatechange = function () {
            if (xhr.readyState === 4 && xhr.status === 200) {
                try {
                    var data = JSON.parse(xhr.responseText);
                    printProjectsTable(data);
                } catch(err) {
                    console.log(err.message + " in " + xhr.responseText);
                    return;
                }
            }
        };

    }

    function printProjectsTable(data) {
        'use strict';
        var html = "";
        for (var i = 0; i < data.length; i++) {
            html +="<tr>";
            html += "<td>"+data[i]['age']+"</td>";
            html += "<td>"+data[i]['email']+"</td>";
            html += "<td>"+data[i]['firstName']+"</td>";
            html += "<td>"+data[i]['password']+"</td>";
            html +="</tr>";
        }
        projectsTable.innerHTML = html;
    }

    form.addEventListener("submit", function (evt) {
        evt.preventDefault();
        if(firstName.value != ""){
            var json = {
                "age": age.value,
                "email": email.value,
                "firstName": firstName.value,
                "password": password.value,
            }
            var formData = JSON.stringify(json);
            console.log(formData);
            var xhr = new XMLHttpRequest();
            xhr.open('POST', 'http://localhost:8080/servlet2', true);
            xhr.setRequestHeader('Content-Type', 'application/json; charset=UTF-8');
            xhr.onreadystatechange = function () {
                if (xhr.readyState === 4 && xhr.status === 200) {
                    getProjects();
                }
            };

            xhr.send(formData);

        }
    });

    getProjects();



function showHideMove() {
    var elem = document.getElementById("img");
    if(elem.style.visibility === "visible"){
        elem.style.visibility = "hidden";
    } else {
        elem.style.visibility= "visible";
    }
}

function ShowHideClick() {
    var elem = document.getElementById("imgSecond");
    if(elem.style.visibility === "visible"){
        elem.style.visibility = "hidden";
    } else {
        elem.style.visibility= "visible";
    }

}

function changeColor() {
    var elem = document.getElementById("button");
    if(elem.style.color === "red"){
        elem.style.color = "green";
    } else if(elem.style.color === "green") {
        elem.style.color = "blue";
    } else {
        elem.style.color = "red";
    }
}



