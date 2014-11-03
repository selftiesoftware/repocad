package com.siigna.web

import com.siigna.web.evaluating.Evaluator
import com.siigna.web.lexing.{LiveStream, Lexer}
import com.siigna.web.parsing.Parser
import org.scalajs.dom.{CanvasRenderingContext2D, HTMLCanvasElement}

import scala.scalajs.js.JSApp
import scala.scalajs.js.annotation.JSExport

@JSExport("Siigna")
class Siigna(canvas : HTMLCanvasElement) {

  val context = canvas.getContext("2d").asInstanceOf[CanvasRenderingContext2D]

  @JSExport
  def clear() : Unit = {
    context.clearRect(0, 0, 10000, 10000);
  }

  @JSExport
  def parse(code : String) : Unit = {
    val stream = LiveStream(code)
    val lexer = new Lexer()
    lexer.lex(stream)
    val tokens = lexer.output
    println(tokens)
    val expressions = Parser.parse(tokens)
    val evaluator = new Evaluator(context)
    println(expressions)

    expressions match {
      case Right(x) => evaluator.eval(x, Map())
      case Left(ms) => println(ms)
    }

  }


}