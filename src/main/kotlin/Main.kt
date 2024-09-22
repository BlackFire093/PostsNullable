package ru.netology

fun main () {
    val post: Post
    val repost: Post
    post = Post(1, "Kotlin is cool", can_pin = true, can_delete = false, can_edit = true, post_type = "copy", 1, is_favorite = true, 0, null)
    repost = Post(1, "Kotlin is cool", can_pin = true, can_delete = false, can_edit = true, post_type = "copy", 1, is_favorite = true, 0, post)

    WallService.add(post)
    WallService.add(repost)
    var sum = 0
    for (item in WallService.posts)
        sum += (item.likes + (item.original?.likes ?: 0))
    println("Sum="+sum)
    WallService.printPosts()
}

data class Post (val id: Int = 0, val Text: String, val can_pin: Boolean, val can_delete: Boolean, val can_edit: Boolean, val post_type: String, val is_pinned: Int, val is_favorite: Boolean, val likes: Int = 0, val original: Post?)


object WallService {

    open var posts = emptyArray<Post>()
    private var lastId = 0

    fun add(post: Post): Post {
        posts += post.copy(id = ++lastId)
        return posts.last()
    }

    fun printPosts() {
        for (post in posts) {
            print (post)
            println(" ")
        }
        println()
    }
}