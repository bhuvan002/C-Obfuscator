//
// Generated by JTB 1.3.2
//

package syntaxtree;

/**
 * Grammar production:

 * f0 -> StructOrUnion()
 * f1 -> ( [ <IDENTIFIER> ] "{" StructDeclarationList() "}" | <IDENTIFIER> )
 */
public class StructOrUnionSpecifier implements Node {
   public StructOrUnion f0;
   public NodeChoice f1;

   public StructOrUnionSpecifier(StructOrUnion n0, NodeChoice n1) {
      f0 = n0;
      f1 = n1;
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
