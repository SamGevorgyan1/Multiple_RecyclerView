package com.multiplerecyclerview.model

object FakeData {

    private val items = mutableListOf<Any>()

    fun getData(): MutableList<Any> {
        items.add(ImagePost("https://images.unsplash.com/photo-1509043759401-136742328bb3?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxleHBsb3JlLWZlZWR8MXx8fGVufDB8fHx8&w=1000&q=80"))
        items.add(ImagePost("https://allthatsinteresting.com/wordpress/wp-content/uploads/2013/09/interesting-pictures-of-clouds.jpg"))
        items.add(
            TextPost(
                textPost = "Pakistan’s foreign minister says that the US ambassador to the country has been summoned after President Joe Biden in a speech said Pakistan “may be one of the most dangerous” countries in the world which had “nuclear weapons without any cohesion”.\n" +
                        "\n" +
                        "The 79-year-old Biden made the comments during a reception of the Democratic Congressional Campaign Committee on Thursday in which he also touched upon the war in Ukraine, China and local domestic issues."
            )
        )

        items.add(ImagePost("https://media.istockphoto.com/photos/businessman-standing-on-the-top-of-rock-picture-id1366352000?b=1&k=20&m=1366352000&s=170667a&w=0&h=Jq1D4K4I0yDJ09kq8Q5fVl40YnstFd_RMI4Pyou0v3E="))
        items.add(ImagePost("https://static.toiimg.com/thumb/msid-87137761,width-748,height-499,resizemode=4,imgsize-101646/.jpg"))

        items.add(
            WebViewPost(
                imageWebView = "https://s.rbk.ru/v1_companies_s3/resized/960xH/media/trademarks/2d456d51-b595-41ec-9f42-32d281a106e3.jpg",
                webViewUrl = "https://kinogo.biz/",

                )
        )

        return items
    }

}
