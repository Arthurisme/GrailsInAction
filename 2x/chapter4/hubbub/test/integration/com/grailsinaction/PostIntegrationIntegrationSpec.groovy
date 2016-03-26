package com.grailsinaction

import grails.test.spock.IntegrationSpec

class PostIntegrationIntegrationSpec extends IntegrationSpec {
    def "Adding posts to user links post to user"() {

        given: "A brand new user"
        def user = new User(loginId: 'joe', password: 'secret')
        user.save(failOnError: true)
        when: "Several posts are added to the user"
        user.addToPosts(new Post(content: "First post... W00t!"))
        user.addToPosts(new Post(content: "Second post..."))
        user.addToPosts(new Post(content: "Third post..."))
        then: "The user has a list of posts attached"
        3 == User.get(user.id).posts.size()
    }




    def "Exercise tagging several posts with various tags"() {

        given: "A user with a set of tags"
        def user = new User(loginId: 'joe', password: 'secret')
        def tagGroovy = new Tag(name: 'groovy')
        def tagGrails = new Tag(name: 'grails')
        user.addToTags(tagGroovy)
        user.addToTags(tagGrails)
        user.save(failOnError: true)

        when: "The user tags two fresh posts"
        def groovyPost = new Post(content: "A groovy post")
        user.addToPosts(groovyPost)
        groovyPost.addToTags(tagGroovy)

        def bothPost = new Post(content: "A groovy and grails post")
        user.addToPosts(bothPost)
        bothPost.addToTags(tagGroovy)
        bothPost.addToTags(tagGrails)

        then:
        user.tags*.name.sort() == [ 'grails', 'groovy']
        1 == groovyPost.tags.size()
        2 == bothPost.tags.size()

    }
}