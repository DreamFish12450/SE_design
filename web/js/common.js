/**
 * 常用功能的聚合
 */
class common {
    //region page_related_menu
    // 这些信息主要用于表示侧边栏的位置，在每个vue页面的info中表示，如果要修改侧边栏，请转至component.js
    // @NoUsed
    static index = 'index'
    /**
     * 模板界面，跳转至template
     */
    static template = 'template'
    /**
     * 书籍列表，支持依据角色的协变(covariance)，当为学生时，转至orderBook，为教师时，转至getBook，其他转至searchBook
     */
    static book_list = 'book_list'
    /**
     * 学院信息，支持页面的协变，支持adminCollage[default]、adminMajor、adminClass、adminTeacher、adminStudent
     */
    static admin_college = 'admin_college'
    /**
     * 二手市场，跳转至bookMarket
     */
    static book_market = 'book_market'
    /**
     * 发布二手书，跳转至publishBook2
     */
    static publish_book = 'publish_book'
    /**
     * 求购二手书，跳转至publishRequest2
     */
    static publish_request = 'publish_request'
    /**
     * 用户界面，支持协变(covariance)，支持index、user_admin、user_student、user_teacher
     */
    static user = 'user'
    /**
     * 添加教师，支持admin_add_teacher
     */
    static admin_add_teacher = 'admin_add_teacher'
    /**
     * 添加学生，支持admin_add_student
     */
    static admin_add_student = 'admin_add_student'
    /**
     * 添加学院，支持admin_add_college
     */
    static admin_add_college = 'admin_add_college'
    /**
     * 添加专业，支持admin_add_major
     */
    static admin_add_major = 'admin_add_major'
    /**
     * 添加班级，支持admin_add_class
     */
    static admin_add_class = 'admin_add_class'
    /**
     * 添加书籍，支持adminAddBook
     */
    static admin_add_book = 'admin_add_book'
    /**
     * 添加课程，支持addCourse
     */
    static admin_add_course = 'admin_add_course'
    /**
     * 开设课程，支持admin_open_course
     */
    static admin_open_course = 'admin_open_course'

    //endregion
    static su = 'su'
    static su_display = '超级管理员'
    static admin = 'admin'
    static admin_display = '学院管理员'
    static teacher = 'teacher'
    static teacher_display = '教师'
    static student = 'student'
    static student_display = '学生'

    /**
     * 获取app默认的状态
     * @param msg
     * @returns {{tip: (string), type: {role: string, display: string, role_display: string}, user: null, status: boolean}}
     */
    static defaultAppState(msg = null) {
        return {
            user: null,
            type: {
                'role': common.student,
                // 显示名称
                'display': '未登录',
                'role_display': common.student_display
            },
            status: false,
            tip: msg === null ? '正在加载中...' : msg
        }
    }

    /**
     * 获取用户的类型
     * @param user
     * @returns {{role: string, display, role_display: string}|{role: string, display: string, role_display: string}}
     */
    static getUserType(user) {
        if (user.su === 1) {
            return {
                'role': common.su,
                'display': common.su_display,
                'role_display': common.su_display
            }
        } else if(user.su === 0) {
            return {
                'role': common.admin,
                // 显示学院的名称
                'display': user.college.name,
                'role_display': common.admin_display
            }
        } else {
            if (user.college !== undefined) {
                return {
                    'role': common.teacher,
                    'display': user.name,
                    'role_display': common.teacher_display
                }
            } else {
                return {
                    'role': common.student,
                    'display': user.name,
                    'role_display': common.student_display
                }
            }
        }
    }

    /**
     * @deprecated
     * 获取用户的状态，推荐使用net.appState()来获取信息
     * @param callback
     */
    static getAppState(callback) {
        request(URL.getLoginStatus, '', (res) => {
            // 成功返回
            if(res.code === 200) {
                callback({
                    user: res.data,
                    type: common.getUserType(res.data),
                    status: true,
                    tip: ''
                })
            } else {
                callback(common.defaultAppState(res.message))
            }
        })
    }

    /**
     * 获取location中#后面的部分，并分析成一个对象
     * @param window
     * @returns {{}|null}
     */
    static getHashDic(window) {
        if (window.location.hash === '' || !window.location.hash.startsWith('#')) {
            return null
        } else {
            let dic = {}
            window.location.hash.slice(1).split('&').forEach((value) => {
                let l = value.split('=')
                dic[l[0]] = l[1]
            })

            return dic
        }
    }
}

