package bg.tu_varna.sit.pmiu_exam3.model

import bg.tu_varna.sit.pmiu_exam3.R

class Datasource {

    val firstList = listOf(
        R.drawable.image1,
        R.drawable.image2,
        R.drawable.image3,
        R.drawable.image4,
        R.drawable.image5,
        R.drawable.image6,
        R.drawable.image7,
        R.drawable.image8,
        R.drawable.image9,
        R.drawable.image10
    ).random()

    fun createPlace() = Place(firstList, "Place ${(1..10).random()}")


}