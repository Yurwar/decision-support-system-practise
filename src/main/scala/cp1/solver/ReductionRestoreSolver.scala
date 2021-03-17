package com.yurwar
package cp1.solver

import common.entity.{Relation, RelationClasses}
import common.util.{RelationPrinter, RelationReader}

class ReductionRestoreSolver extends AbstractRestoreSolver {
  val taskFileName = "src/main/resources/cp1/binary_relations_task2.1.txt"

  override def solve(): Unit = {
    val a: RelationReader = new RelationReader

    val relations = a.parseRelations(taskFileName)

    val relationForStrictOrder = relations.head
    val relationForNotStrictOrder = new Relation(relationForStrictOrder.matrix)


    println(s"Start restoring ${RelationClasses.StrictOrder} for relation")
    RelationPrinter.printRelationMatrix(relationForStrictOrder)
    restoreClassForRelation(relationForStrictOrder, RelationClasses.StrictOrder)

    println(s"Start restoring ${RelationClasses.NotStrictOrder} for relation")
    RelationPrinter.printRelationMatrix(relationForNotStrictOrder)
    restoreClassForRelation(relationForNotStrictOrder, RelationClasses.NotStrictOrder)
  }
}