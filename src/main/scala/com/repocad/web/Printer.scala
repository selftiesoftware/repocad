package com.repocad.web

import com.repocad.web.evaluating.Evaluator

/**
 * A printer that can print objects on a medium
 */
trait Printer {

  /**
   * Draws an arc
   * @param x First coordinate
   * @param y Second coordinate
   * @param r Radius
   * @param sAngle start angle (3'o clock)
   * @param eAngle end angle
   *
   */

  def arc(x : Double, y : Double, r : Double, sAngle : Double, eAngle : Double)

  /**
   * Draws a bezier curve
   * @param x1 start x
   * @param y1 start y
   * @param x2 control point1 x
   * @param y2 control point1 y
   * @param x3 control point2 x
   * @param y3 control point2 y
   * @param x4 end x
   * @param y4 start y
   *
   */
  def bezierCurve(x1 : Double, y1 : Double, x2 : Double, y2 : Double, x3 : Double, y3 : Double, x4 : Double, y4 : Double)

  /**
   * Draws a circle
   * @param x First coordinate
   * @param y Second coordinate
   * @param r Radius
   */
  def circle(x : Double, y : Double, r : Double)

  /**
   * Renders a text string
   * @param x First coordinate
   * @param y Second coordinate
   * @param h Height
   * @param t Text
   */
  def text(x : Double, y : Double, h : Double, t : Any)

  /**
   * Renders a text box
   * @param x First coordinate
   * @param y Second coordinate
   * @param w Width
   * @param h Line height
   * @param t Text
   */
  def textBox(x : Double, y : Double, w: Double, h : Double, t : Any)

  /**
   * Draws a line
   * @param x1 First coordinate
   * @param y1 Second coordinate
   * @param x2 Third coordinate
   * @param y2 Fourth coordinate
   */
  def line(x1 : Double, y1 : Double, x2 : Double, y2 : Double)

  lazy val toEnv : Evaluator.Env = {
    Map(
      "arc"  -> ((p : Printer, x : Double, y : Double, r : Double, sAngle : Double, eAngle : Double) => arc(x, y, r, sAngle, eAngle)),
      "bezierCurve" -> ((p : Printer, x1 : Double, y1 : Double, x2 : Double, y2 : Double, x3 : Double, y3 : Double, x4 : Double, y4 : Double) => bezierCurve(x1, y1, x2, y2, x3, y3, x4, y4)),
      "circle" -> ((p : Printer, x : Double, y : Double, r : Double) => circle(x, y, r)),
      "line" -> ((p : Printer, x1 : Double, y1 : Double, x2 : Double, y2 : Double) => line(x1, y1, x2, y2)),
      "text" -> ((p : Printer, x : Double, y : Double, h : Double, t : Any) => text(x, y, h, t)),
      "textBox" -> ((p : Printer, x : Double, y : Double, w: Double, h : Double, t : Any) => textBox(x, y, w, h, t))
    )
  }
}