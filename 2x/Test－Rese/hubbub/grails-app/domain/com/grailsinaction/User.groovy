package com.grailsinaction

class User {

    String loginId
    String password
//    String homepage
    Date dateCreated

    static hasOne =[profile: Profile]
    static hasMany = [ posts : Post, tags : Tag, following : User ]

    static constraints = {
        loginId size: 3..20, unique: true, nullable: false
        password size: 6..8, blank: false, validator: { passwd, user ->
            return  passwd != user.loginId
        }
//        homepage url: true, nullable: true
        tags()
        posts()
        profile nullable: true
    }

    static mapping = {
        posts sort: "dateCreated", order: "desc"
    }
}

