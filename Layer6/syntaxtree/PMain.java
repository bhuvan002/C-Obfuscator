//
// Generated by JTB 1.3.2
//

package syntaxtree;

/**
 * Grammar production:
 * f0 -> MainReturnType()
 * f1 -> <MAIN>
 * f2 -> "("
 * f3 -> [ <INT> Identifier() "," <CHAR> "*" [ "*" ] Identifier() [ "[" "]" ] ]
 * f4 -> ")"
 * f5 -> SimpleBlock()
 */
public class PMain implements Node {
   public MainReturnType f0;
   public NodeToken f1;
   public NodeToken f2;
   public NodeOptional f3;
   public NodeToken f4;
   public SimpleBlock f5;

   public PMain(MainReturnType n0, NodeToken n1, NodeToken n2, NodeOptional n3, NodeToken n4, SimpleBlock n5) {
      f0 = n0;
      f1 = n1;
      f2 = n2;
      f3 = n3;
      f4 = n4;
      f5 = n5;
   }

   public PMain(MainReturnType n0, NodeOptional n1, SimpleBlock n2) {
      f0 = n0;
      f1 = new NodeToken("main");
      f2 = new NodeToken("(");
      f3 = n1;
      f4 = new NodeToken(")");
      f5 = n2;
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
