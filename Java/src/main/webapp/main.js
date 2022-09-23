function openDeleteForm() {
    document.getElementById("delete-form").style.display = "block";
}

function closeDeleteForm() {
    document.getElementById("delete-form").style.display = "none";
}
 
//REPORT
function openReportForm() {
    document.getElementById("report-form").style.display = "block";
}

function closeReportForm() {
    document.getElementById("report-form").style.display = "none";
}

//QUERY
function openQueryForm() {
    document.getElementById("query-form").style.display = "block";
}

function closeQueryForm() {
    document.getElementById("query-form").style.display = "none";
}

//ADD
function openAddForm() {
    document.getElementById("add-form").style.display = "block";
}

function closeAddForm() {
    document.getElementById("add-form").style.display = "none";
}

//UPDATE
function openUpdateForm() {
    document.getElementById("update-form").style.display = "block";
}

function closeUpdateForm() {
    document.getElementById("update-form").style.display = "none";
}

/* VALIDATION */

//DELETE
function validateDeleteForm() {
    let x = document.forms["delete-form"]["delete-stdid"].value;
    if (x == "") {
    alert("Please enter the Student ID");
    return false;
    }
}

//ADD
function validateAddForm() {
    let stdid = document.forms["add-form"]["add-stdid"].value;
    let stdname = document.forms["add-form"]["add-stdname"].value;
    let m1 = document.forms["add-form"]["add-m1"].value;
    let m2 = document.forms["add-form"]["add-m2"].value;
    let m3 = document.forms["add-form"]["add-m3"].value;
    let m4 = document.forms["add-form"]["add-m4"].value;
    let m5 = document.forms["add-form"]["add-m5"].value;


    if (stdid == "") {
        alert("Please enter the Student ID");
        return false;
    }

    if (stdname == "") {
        alert("Please enter the Student name");
        return false;
    }

    if (m1 == "") {
        alert("Please enter Subject 1 Marks");
        return false;
    }

    if (m2 == "") {
        alert("Please enter Subject 2 Marks");
        return false;
    }

    if (m3 == "") {
        alert("Please enter Subject 3 Marks");
        return false;
    }

    if (m4 == "") {
        alert("Please enter Subject 4 Marks");
        return false;
    }

    if (m5 == "") {
        alert("Please enter Subject 5 Marks");
        return false;
    }
}


//UPDATE
function validateUpdateForm() {
    let x = document.forms["update-form"]["update-stdid"].value;
    if (x == "") {
    alert("Please enter the Student ID");
    return false;
    }
}

//REPORT
function validateReportForm() {
    let x = document.forms["report-form"]["report-stdid"].value;
    if (x == "") {
        alert("Please enter the Student ID");
        return false;
    }
}