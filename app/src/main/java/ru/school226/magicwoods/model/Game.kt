package ru.school226.magicwoods.model

abstract class Entity(
    var x: Int = 0,
    var y: Int = 0
) {
    fun goto(x: Int, y: Int): Entity {
        this.x = x
        this.y = y
        return this
    }
}

class Tree : Entity()

class Player(
    name: String,
    maxHealth: Int
) : Entity()

class Game {
    val player = Player("Никита", 30).goto(0, 0)

    /*
    Мини-карта леса:
      01234
    0 P  *
    1  * *
    2 *  *
     */
    val entities = mutableListOf<Entity>(
        Tree().goto(1, 1),
        Tree().goto(3, 0),
        Tree().goto(0, 2),
        Tree().goto(3, 2),
        Tree().goto(3, 1)
    )

    fun move(dx: Int, dy: Int) {
        var newX = player.x + dx
        var newY = player.y + dy

        val entity = entities.find { it.x == newX && it.y == newY }

        if (entity == null) {
            player.goto(newX, newY)
        }
    }
}