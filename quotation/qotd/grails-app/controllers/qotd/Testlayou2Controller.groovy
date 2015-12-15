package qotd

class Testlayou2Controller {

    def index() {}

    def random() {
        def staticAuthor = "Anonymous"
        def staticContent = "Real Programmers don't eat much quiche"
        [author: staticAuthor, content: staticContent]
    }

    def test1() {
        def staticAuthor = "Anonymous"
        def staticContent = "Real Programmers don't eat much quiche"
        [author: staticAuthor, content: staticContent]
    }

}
