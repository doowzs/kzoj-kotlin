package cn.kzoj.data.problem

import cn.kzoj.models.problem.Problem
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class ProblemDAO(id: EntityID<Int>) : IntEntity(id) {
    companion object: IntEntityClass<ProblemDAO>(ProblemTable)

    var title                   by ProblemTable.title
    var author                  by ProblemTable.author
    var createdByUser           by ProblemTable.createdByUser
    var description             by ProblemTable.description
    var timeLimit               by ProblemTable.timeLimit
    var memoryLimit             by ProblemTable.memoryLimit
    var stackLimit              by ProblemTable.stackLimit
    var inputDescription        by ProblemTable.inputDescription
    var outputDescription       by ProblemTable.outputDescription
    var examples                by ProblemTable.examples
    var problemSource           by ProblemTable.problemSource
    var difficulty              by ProblemTable.difficulty
    var tip                     by ProblemTable.tip
    var status                  by ProblemTable.status
    var score                   by ProblemTable.score
    var localTimeCreated        by ProblemTable.localTimeCreated
    var localTimeLastModified   by ProblemTable.localTimeLastModified
}

fun ProblemDAO.expose(): Problem =
    Problem(
        id = this.id.value,
        title = this.title,
        author = this.author,
        createdByUser = this.createdByUser,
        description = this.description,
        timeLimit = this.timeLimit,
        memoryLimit = this.memoryLimit,
        stackLimit = this.stackLimit,
        inputDescription = this.inputDescription,
        outputDescription = this.outputDescription,
        examples = this.examples,
        problemSource = this.problemSource,
        difficulty = this.difficulty,
        tip = this.tip,
        status = this.status,
        score = this.score,
        localTimeCreated = localTimeCreated,
        localTimeLastModified = localTimeLastModified,
    )

fun List<ProblemDAO>.expose(): List<Problem> =
    let {
        val problemArrayList: ArrayList<Problem> = arrayListOf()
        it.forEach { problemArrayList.add(it.expose()) }
        problemArrayList.toList()
    }