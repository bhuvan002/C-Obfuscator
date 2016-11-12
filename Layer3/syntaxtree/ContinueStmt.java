//
// Generated by JTB 1.3.2
//

package syntaxtree;

/**
 * Grammar production:
 * f0 -> <CONTINUE>
 * f1 -> ";"
 */
public class ContinueStmt implements Node {
   public NodeToken f0;
   public NodeToken f1;

   public ContinueStmt(NodeToken n0, NodeToken n1) {
      f0 = n0;
      f1 = n1;
   }

   public ContinueStmt() {
      f0 = new NodeToken("continue");
      f1 = new NodeToken(";");
   }

   public void accept(visitor.Visitor v) {
      v.visit(this);
   }
   public <R,A> R accept(visitor.GJVisitor<R,A> v, A argu) {
      return v.visit(this,argu);
   }
   public <R> R accept(visitor.GJNoArguVisitor<R> v) {
      return v.visit(this);
   }
   public <A> void accept(visitor.GJVoidVisitor<A> v, A argu) {
      v.visit(this,argu);
   }
}

