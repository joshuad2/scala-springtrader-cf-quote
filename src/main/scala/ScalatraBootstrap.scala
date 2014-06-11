import org.scalatra.LifeCycle
import javax.servlet.ServletContext
import com.pivotal.demo.scalatra._
/**
 * This is the default bootstrap class for Scalatra
 * @Author Joshua Davis
 */
class ScalatraBootstrap extends LifeCycle {

  override def init(context: ServletContext) {

    context mount (new QuoteScalatra, "/*")
  }
}