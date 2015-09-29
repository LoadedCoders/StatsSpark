import org.apache.spark.mllib.stat.{MultivariateStatisticalSummary, Statistics}
import org.apache.spark.util.StatCounter
import org.apache.spark.{SparkContext, SparkConf}

/**
 * Created by pradyumnad on 9/29/15.
 */
object StatsApp {

  def main(args: Array[String]) {

    val conf = new SparkConf().setMaster("local[*]").setAppName("StatsApp")
    val sc = new SparkContext(conf)

    val lines = sc.textFile("files/1.txt").map(_.toInt).cache()

    val stats:StatCounter = lines.stats()
    println(stats.toString())

    sc.stop()
  }
}
