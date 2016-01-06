package qotd


class QuoteController {
    static scaffold = true

//    def index() { }

    def home() {
        render "<h1>Real Programmers do not eat Quiche</h1>"
    }

    def love() {
        render "<h1>Love is the most beautiful language, It is the God</h1>"
    }

//    def random() {
//        def staticAuthor = "Anonymous"
//        def staticContent = "Real Programmers don't eat much quiche"
//        [ author: staticAuthor, content: staticContent]
//    }

    def random() {

        def allQuotes = Quote.list()
        def randomQuote

        if (allQuotes.size() > 0){

            def randomIdx = new Random().nextInt(allQuotes.size())
            randomQuote = allQuotes[randomIdx]

        }else{
              randomQuote = new Quote(author: "Anonymous",
                    content: "Real Programmers don't eat much Quiche")        }





        [ quote : randomQuote]
    }

    def random2() {
        def staticAuthor = "Anonymous"
        def staticContent = "Real Programmers don't eat much quiche"
        [ author: staticAuthor, content: staticContent]
    }

}