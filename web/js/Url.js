class URL {

    static protocol = document.location.protocol + "//"
    static host = (document.location.host + ":").split(":")[0] //防止本身有端口时出现两次端口号
    static port = "8082"
    static path = ""
    static header = this.protocol + this.host + ":" + this.port + this.path
    // static header = "https://api.otsp.top:8082"
    static StudentHeader = this.header + "/student"

    static InsertBook = this.header + "/book/insert"
    static SelectBook = this.header + "/book/select"
    static SearchBook = this.header + "/book/search"
    static SearchBookStu = this.header + "/book/search_stu"
    static SearchBookTeacher = this.header + "/book/search_teacher"
    static SearchBookAdmin = this.header + "/book/search_admin"
    static OrderBookStu = this.header + "/book/order_stu"
    static OrderBookTeacher = this.header + "/book/order_teacher"
    static DeleteBook = this.header + "/book/delete"
    static UpdateBook = this.header + "/book/update"
    static ListBook = this.header + "/book/list"
    static FuzzyBook = this.header + "/book/fuzzy"
    static InsertCollege = this.header + "/college/insert"
    static GetCollege = this.header + "/college/get"
    static GetCollegeByMajor = this.header + "/college/get_major"
    static SelectCollege = this.header + "/college/select"
    static DeleteCollege = this.header + "/college/delete"
    static ListCollege = this.header + "/college/list"
    static ListCourse = this.header + "/course/list"
    static AllCourse = this.header + "/course/all"
    static AddCourse = this.header + "/course/add"
    static ListCourseByMajor = this.header + "/course/list/by/major"
    static SelectStudent = this.header + "/student/select"
    static InsertOpenCourse = this.header + "/course_open/insert"
    static ListOpenCourse = this.header + "/course_open/list"
    static PutImage = this.header + "/image/put"
    static GetImage = this.header + "/image/get"
    static InsertMajor = this.header + "/major/insert"
    static GetMajor = this.header + "/major/get"
    static ListMajor = this.header + "/major/list"
    static FetchAllMajor = this.header + "/major/fetch_all"
    static AllMajor = this.header + "/major/all"
    static SelectMajorByYear = this.header + "/major/by/year"
    static UpdateMajor = this.header + "/major/update"
    static DeleteMajor = this.header + "/major/delete"
    static SelectClassByMajor = this.header + "/class/fetch_all"
    static ListSecondHandFind = this.header + "/second/find/select/all"
    static SelectSecondHandFindByIsbn = this.header + "/second/find/select"
    static SelectSecondHandFindByStudent = this.header + "/second/find/selectByStudent"
    static CancelSecondHandFind = this.header + "/second/find/cancel"
    static ChangeStatusOkSecondHandFind = this.header + "/second/find/changeStatusOk"
    static SelectSecondHandPublishBuyList = this.header + "/second/publish/buyList"
    static SelectSecondHandPublishExchangeList = this.header + "/second/publish/exchangeList"
    static SelectSecondHandPublishPurchase = this.header + "/second/publish/purchase"
    static InsertSecondHandPublish = this.header + "/second/publish/insert"
    static CancelSecondHandPublish = this.header + "/second/publish/cancel"
    static InsertSecondHandFind = this.header + "/second/find/insert"
    static SelectSecondHandFindOtherExchangeList = this.header + "/second/find/other_exchange/list"
    static SecondHandPostExchange = this.header + "/second/find/post_exchange"
    static DeleteSecondHandPublish = this.header + "/second/publish/delete"
    static UpdateSecondHandPublish = this.header + "/second/publish/update"
    static ListSecondHandPublish = this.header + "/second/publish/select/all"
    static SelectSecondHandPublishByIsbn = this.header + "/second/publish/selectByISBN"
    static SelectSecondHandPublishByStudent = this.header + "/second/publish/selectByStudent"
    static ChangeStatusOkSecondHandPublish = this.header + "/second/publish/changeStatusOk"
    static InsertStudent = this.header + "/student/insert"
    static DeleteStudent = this.header + "/student/delete"
    static SelectStudentById = this.header + "/student/select"
    static UpdateStudent = this.header + "/student/update"
    static ChargeForStudent = this.header + "/student/{id}/charge"
    static ConsumeForStudent = this.header + "/student/{id}/charge"
    static InsertTeacher = this.header + "/teacher/insert"
    static SelectTeacherById = this.header + "/teacher/selectById"
    static SelectTeacherByName = this.header + "/teacher/selectByName"
    static ListTeacher = this.header + "/teacher/list"
    static SelectAllTeacher = this.header + "/teacher/selectAll"
    static SelectTeacherByCollege = this.header + "/teacher/selectByCollegeId"
    static DeleteTeacher = this.header + "/teacher/deleteById"
    static Login = this.header + "/login"
    static getLoginStatus = this.header + "/account/status"
    static getLoginUsername = this.header + "/account/username"
    static Logout = this.header + "/logout"
    static Status = this.header + "/account/status"
    static FuzzyTeacher = this.header + "/teacher/fuzzy"
    static FuzzyCourse = this.header + '/course/fuzzy'
    static FuzzyCollege = this.header + "/college/fuzzy"
    static FuzzyMajor = this.header + "/major/fuzzy"
    static FuzzyCourseWithMajor = this.header + "/course/fuzzy/by/major"
    static IdDuplicate = this.header + "/account/duplicate"
    static SelectCourse = this.header + "/course/select"
    static ResetPassword = this.header + "/password/reset"
    static SelectAdmin = this.header + "/admin/select"
    static GetClass = this.header + "/class/select"
    static SelectStudentByClazz = this.header + "/student/selectByClass"
    static InsertCollegeThenGetId = this.header + '/college/insert/id'
    static InsertAdmin = this.header + "/admin/insert"
    static InsertClass = this.header + "/class/insert"
    static selectClassByMajor = this.header + "/class/selectByMajor"
    static GetClassListByCollegeId = this.header + "/class/fetch_college"

    static ExportBookAndSetReceived = this.header + "/book/order/export"
    static ExportBookFromTeacherRequest = this.header + "/book/request/export"

    static getImage(url) {
        return URL.GetImage + "/" + url
    }
}


function request(url, body, callback) {
    let formRequest = new Request(url, {
        method: 'post',
        credentials: 'include',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8;'
        },
        body: body
    })
    fetch(formRequest).then(response => {
        let result = response.json()
        result.then(res => {
            callback(res)
        })
    })
}


let default_headers = {
    'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8;'
}

let json_headers = {
    'Content-Type': 'application/json;charset=utf-8;'
}


function request_su(url, body, callback, headers = default_headers) {
    let form = new Request(url, {
        method: 'post',
        credentials: 'include',
        headers: headers,
        body: body
    })
    fetch(form).then(response => {
        response.json().then(result => {
            let status = response.status
            callback(status, result)
        })
    })
}
