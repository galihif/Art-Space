package com.giftech.art_space.utils

import com.giftech.art_space.model.Art

fun artDummyData():ArrayList<Art>{
    return arrayListOf(
        Art(
            image = "https://uploads0.wikiart.org/00339/images/leonardo-da-vinci/mona-lisa-c-1503-1519.jpg",
            title = "Mona Lisa",
            artist = "Leonardo da Vinci",
            year = "1503"
        ),
        Art(
            image = "https://upload.wikimedia.org/wikipedia/commons/thumb/e/ea/Van_Gogh_-_Starry_Night_-_Google_Art_Project.jpg/1200px-Van_Gogh_-_Starry_Night_-_Google_Art_Project.jpg",
            title = "The Starry Night",
            artist = " Vincent van Gogh",
            year = "1889"
        ),
        Art(
            image = "https://upload.wikimedia.org/wikipedia/commons/thumb/0/0f/1665_Girl_with_a_Pearl_Earring.jpg/800px-1665_Girl_with_a_Pearl_Earring.jpg",
            title = "Girl with a Pearl Earring ",
            artist = "Johannes Vermeer",
            year = "1665"
        ),
        Art(
            image = "https://www.gustav-klimt.com/images/paintings/The-Kiss.jpg",
            title = "The Kiss",
            artist = "Gustav Klimt",
            year = "1908"
        ),

    )
}