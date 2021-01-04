/**
 * 前端数据转换器，用于将后端的数据改成自己想要的数据
 */
class convert {
    /**
     * 转换book中的数据为合适的类型
     * @param books
     * @returns {*}
     */
    static books(books) {
        books.forEach((book) => {
            book.searching = false
            book.book.cover = URL.getImage(book.book.cover)
            book.book.price = book.book.price / 100
        })
        return books
    }

    /**
     * 按照学年和学期过滤书籍
     * @param books
     * @param year
     * @param semester
     */
    static filter_books(books, year, semester) {
        return books.filter((book) => {
            return book.courseOpens.find((courseOpen) => courseOpen.year.toString() === year.toString() && courseOpen.semester.toString() === semester.toString()) !== undefined
        })
    }

    static colleges(colleges) {
        colleges.forEach((college) => {
            college.canDelete = college.studentCount + college.teacherCount + college.majorCount === 0
        })
        return colleges
    }

    static majors(majors) {
        majors.forEach((major) => {
            major.canDelete = major.studentCount + major.classCount === 0
        })
        return majors
    }

    static classes(classes) {
        classes.forEach((clazz) => {
            clazz.canDelete = clazz.studentCount === 0
        })
    }


    static secondHand(publishes) {
        publishes.forEach((publish) => {
            publish.book.cover = URL.getImage(publish.book.cover)
            publish.book.price = publish.book.price / 100
            publish.price = publish.price / 100
        })
    }

}