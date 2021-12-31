package com.fq.navigationtutorial

class DraggableModel{
    val draggableItems = ArrayList<DraggableItem>()

    init {
        draggableItems.add(DraggableTopicOneItem("Golgi Apparatus", com.fq.navigationtutorial.R.drawable.golgi, "Who is responsible for modifying and packaging proteins and lipids into vesicles?"))
        draggableItems.add(DraggableTopicOneItem("Mitochondria", com.fq.navigationtutorial.R.drawable.mitochondria, "Which is the organelle responsible for producing cell energy that contains a unique genome?"))
        draggableItems.add(DraggableTopicOneItem("Ribosomes", com.fq.navigationtutorial.R.drawable.ribosome, "What is the name of a cellular particle made of RNA and protein that serves as the site for protein synthesis in the cell?"))
        draggableItems.add(DraggableTopicOneItem("Nucleus", com.fq.navigationtutorial.R.drawable.nucleus, "Name the eukaryotic organelle which fully enclosed membrane contains the majority of the cell's genetic material:"))

        draggableItems.add(DraggableTopicTwoItem("Topic 2.1", com.fq.navigationtutorial.R.drawable.square, "TEST 2"))
        draggableItems.add(DraggableTopicTwoItem("Topic 2.2", com.fq.navigationtutorial.R.drawable.square, "TEST 2"))
        draggableItems.add(DraggableTopicTwoItem("Topic 2.3", com.fq.navigationtutorial.R.drawable.square, "TEST 2"))
        draggableItems.add(DraggableTopicTwoItem("Topic 2.4", com.fq.navigationtutorial.R.drawable.square, "TEST 2"))

        draggableItems.add(DraggableTopicThreeItem("Topic 3.1", com.fq.navigationtutorial.R.drawable.square, "TEST 3"))
        draggableItems.add(DraggableTopicThreeItem("Topic 3.2", com.fq.navigationtutorial.R.drawable.square, "TEST 3"))
        draggableItems.add(DraggableTopicThreeItem("Topic 3.3", com.fq.navigationtutorial.R.drawable.square, "TEST 3"))
        draggableItems.add(DraggableTopicThreeItem("Topic 3.4", com.fq.navigationtutorial.R.drawable.square, "TEST 3"))
    }
}