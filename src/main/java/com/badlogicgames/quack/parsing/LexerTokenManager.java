/* Generated By:JavaCC: Do not edit this line. LexerTokenManager.java */
package com.badlogicgames.quack.parsing;

/** Token Manager. */
public class LexerTokenManager implements LexerConstants
{

  /** Debug output. */
  public  java.io.PrintStream debugStream = System.out;
  /** Set debug output. */
  public  void setDebugStream(java.io.PrintStream ds) { debugStream = ds; }
private final int jjStopStringLiteralDfa_0(int pos, long active0, long active1)
{
   switch (pos)
   {
      case 0:
         if ((active0 & 0x7000L) != 0L)
         {
            jjmatchedKind = 26;
            return 26;
         }
         if ((active0 & 0x2000000000L) != 0L || (active1 & 0x200L) != 0L)
            return 3;
         if ((active0 & 0x100000000000080L) != 0L || (active1 & 0x2L) != 0L)
            return 45;
         return -1;
      case 1:
         if ((active0 & 0x7000L) != 0L)
         {
            if (jjmatchedPos != 1)
            {
               jjmatchedKind = 26;
               jjmatchedPos = 1;
            }
            return 26;
         }
         if ((active0 & 0x80L) != 0L)
            return 43;
         return -1;
      case 2:
         if ((active0 & 0x7000L) != 0L)
            return 26;
         return -1;
      default :
         return -1;
   }
}
private final int jjStartNfa_0(int pos, long active0, long active1)
{
   return jjMoveNfa_0(jjStopStringLiteralDfa_0(pos, active0, active1), pos + 1);
}
private int jjStopAtPos(int pos, int kind)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   return pos + 1;
}
private int jjMoveStringLiteralDfa0_0()
{
   switch(curChar)
   {
      case 33:
         jjmatchedKind = 41;
         return jjMoveStringLiteralDfa1_0(0x1000000000000L, 0x0L);
      case 37:
         jjmatchedKind = 60;
         return jjMoveStringLiteralDfa1_0(0x0L, 0x20L);
      case 38:
         jjmatchedKind = 57;
         return jjMoveStringLiteralDfa1_0(0x4000000000000L, 0x4L);
      case 40:
         return jjStopAtPos(0, 29);
      case 41:
         return jjStopAtPos(0, 30);
      case 42:
         jjmatchedKind = 55;
         return jjMoveStringLiteralDfa1_0(0x0L, 0x1L);
      case 43:
         jjmatchedKind = 53;
         return jjMoveStringLiteralDfa1_0(0x4008000000000000L, 0x0L);
      case 44:
         return jjStopAtPos(0, 36);
      case 45:
         jjmatchedKind = 54;
         return jjMoveStringLiteralDfa1_0(0x8010000000000000L, 0x0L);
      case 46:
         jjmatchedKind = 37;
         return jjMoveStringLiteralDfa1_0(0x0L, 0x200L);
      case 47:
         jjmatchedKind = 56;
         return jjMoveStringLiteralDfa1_0(0x80L, 0x2L);
      case 58:
         return jjStopAtPos(0, 44);
      case 59:
         return jjStopAtPos(0, 35);
      case 60:
         jjmatchedKind = 40;
         return jjMoveStringLiteralDfa1_0(0x2000400000000000L, 0x40L);
      case 61:
         jjmatchedKind = 39;
         return jjMoveStringLiteralDfa1_0(0x200000000000L, 0x0L);
      case 62:
         return jjMoveStringLiteralDfa1_0(0x800000000000L, 0x180L);
      case 63:
         return jjStopAtPos(0, 43);
      case 64:
         return jjStopAtPos(0, 38);
      case 91:
         return jjStopAtPos(0, 33);
      case 93:
         return jjStopAtPos(0, 34);
      case 94:
         jjmatchedKind = 59;
         return jjMoveStringLiteralDfa1_0(0x0L, 0x10L);
      case 100:
         return jjMoveStringLiteralDfa1_0(0x1000L, 0x0L);
      case 118:
         return jjMoveStringLiteralDfa1_0(0x6000L, 0x0L);
      case 123:
         return jjStopAtPos(0, 31);
      case 124:
         jjmatchedKind = 58;
         return jjMoveStringLiteralDfa1_0(0x2000000000000L, 0x8L);
      case 125:
         return jjStopAtPos(0, 32);
      case 126:
         return jjStopAtPos(0, 42);
      default :
         return jjMoveNfa_0(0, 0);
   }
}
private int jjMoveStringLiteralDfa1_0(long active0, long active1)
{
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(0, active0, active1);
      return 1;
   }
   switch(curChar)
   {
      case 38:
         if ((active0 & 0x4000000000000L) != 0L)
            return jjStopAtPos(1, 50);
         break;
      case 42:
         if ((active0 & 0x80L) != 0L)
            return jjStartNfaWithStates_0(1, 7, 43);
         break;
      case 43:
         if ((active0 & 0x8000000000000L) != 0L)
            return jjStopAtPos(1, 51);
         break;
      case 45:
         if ((active0 & 0x10000000000000L) != 0L)
            return jjStopAtPos(1, 52);
         break;
      case 46:
         return jjMoveStringLiteralDfa2_0(active0, 0L, active1, 0x200L);
      case 60:
         if ((active0 & 0x2000000000000000L) != 0L)
         {
            jjmatchedKind = 61;
            jjmatchedPos = 1;
         }
         return jjMoveStringLiteralDfa2_0(active0, 0L, active1, 0x40L);
      case 61:
         if ((active0 & 0x200000000000L) != 0L)
            return jjStopAtPos(1, 45);
         else if ((active0 & 0x400000000000L) != 0L)
            return jjStopAtPos(1, 46);
         else if ((active0 & 0x800000000000L) != 0L)
            return jjStopAtPos(1, 47);
         else if ((active0 & 0x1000000000000L) != 0L)
            return jjStopAtPos(1, 48);
         else if ((active0 & 0x4000000000000000L) != 0L)
            return jjStopAtPos(1, 62);
         else if ((active0 & 0x8000000000000000L) != 0L)
            return jjStopAtPos(1, 63);
         else if ((active1 & 0x1L) != 0L)
            return jjStopAtPos(1, 64);
         else if ((active1 & 0x2L) != 0L)
            return jjStopAtPos(1, 65);
         else if ((active1 & 0x4L) != 0L)
            return jjStopAtPos(1, 66);
         else if ((active1 & 0x8L) != 0L)
            return jjStopAtPos(1, 67);
         else if ((active1 & 0x10L) != 0L)
            return jjStopAtPos(1, 68);
         else if ((active1 & 0x20L) != 0L)
            return jjStopAtPos(1, 69);
         break;
      case 62:
         return jjMoveStringLiteralDfa2_0(active0, 0L, active1, 0x180L);
      case 97:
         return jjMoveStringLiteralDfa2_0(active0, 0x6000L, active1, 0L);
      case 101:
         return jjMoveStringLiteralDfa2_0(active0, 0x1000L, active1, 0L);
      case 124:
         if ((active0 & 0x2000000000000L) != 0L)
            return jjStopAtPos(1, 49);
         break;
      default :
         break;
   }
   return jjStartNfa_0(0, active0, active1);
}
private int jjMoveStringLiteralDfa2_0(long old0, long active0, long old1, long active1)
{
   if (((active0 &= old0) | (active1 &= old1)) == 0L)
      return jjStartNfa_0(0, old0, old1);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(1, active0, active1);
      return 2;
   }
   switch(curChar)
   {
      case 46:
         if ((active1 & 0x200L) != 0L)
            return jjStopAtPos(2, 73);
         break;
      case 61:
         if ((active1 & 0x40L) != 0L)
            return jjStopAtPos(2, 70);
         else if ((active1 & 0x80L) != 0L)
            return jjStopAtPos(2, 71);
         break;
      case 62:
         return jjMoveStringLiteralDfa3_0(active0, 0L, active1, 0x100L);
      case 102:
         if ((active0 & 0x1000L) != 0L)
            return jjStartNfaWithStates_0(2, 12, 26);
         break;
      case 108:
         if ((active0 & 0x2000L) != 0L)
            return jjStartNfaWithStates_0(2, 13, 26);
         break;
      case 114:
         if ((active0 & 0x4000L) != 0L)
            return jjStartNfaWithStates_0(2, 14, 26);
         break;
      default :
         break;
   }
   return jjStartNfa_0(1, active0, active1);
}
private int jjMoveStringLiteralDfa3_0(long old0, long active0, long old1, long active1)
{
   if (((active0 &= old0) | (active1 &= old1)) == 0L)
      return jjStartNfa_0(1, old0, old1);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(2, 0L, active1);
      return 3;
   }
   switch(curChar)
   {
      case 61:
         if ((active1 & 0x100L) != 0L)
            return jjStopAtPos(3, 72);
         break;
      default :
         break;
   }
   return jjStartNfa_0(2, 0L, active1);
}
private int jjStartNfaWithStates_0(int pos, int kind, int state)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) { return pos + 1; }
   return jjMoveNfa_0(state, pos + 1);
}
static final long[] jjbitVec0 = {
   0xfffffffffffffffeL, 0xffffffffffffffffL, 0xffffffffffffffffL, 0xffffffffffffffffL
};
static final long[] jjbitVec2 = {
   0x0L, 0x0L, 0xffffffffffffffffL, 0xffffffffffffffffL
};
private int jjMoveNfa_0(int startState, int curPos)
{
   int startsAt = 0;
   jjnewStateCnt = 68;
   int i = 1;
   jjstateSet[0] = startState;
   int kind = 0x7fffffff;
   for (;;)
   {
      if (++jjround == 0x7fffffff)
         ReInitRounds();
      if (curChar < 64)
      {
         long l = 1L << curChar;
         do
         {
            switch(jjstateSet[--i])
            {
               case 0:
                  if ((0x3ff000000000000L & l) != 0L)
                  {
                     if (kind > 19)
                        kind = 19;
                     jjCheckNAddStates(0, 5);
                  }
                  else if (curChar == 47)
                     jjAddStates(6, 7);
                  else if (curChar == 34)
                     jjCheckNAddStates(8, 10);
                  else if (curChar == 39)
                     jjAddStates(11, 12);
                  else if (curChar == 46)
                     jjCheckNAdd(3);
                  if ((0x3fe000000000000L & l) != 0L)
                  {
                     if (kind > 15)
                        kind = 15;
                     jjCheckNAdd(1);
                  }
                  else if (curChar == 48)
                  {
                     if (kind > 15)
                        kind = 15;
                     jjCheckNAddStates(13, 16);
                  }
                  break;
               case 45:
                  if (curChar == 47)
                  {
                     if (kind > 8)
                        kind = 8;
                     jjCheckNAddStates(17, 19);
                  }
                  else if (curChar == 42)
                     jjstateSet[jjnewStateCnt++] = 43;
                  break;
               case 1:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 15)
                     kind = 15;
                  jjCheckNAdd(1);
                  break;
               case 2:
                  if (curChar == 46)
                     jjCheckNAdd(3);
                  break;
               case 3:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 19)
                     kind = 19;
                  jjCheckNAddTwoStates(3, 4);
                  break;
               case 5:
                  if ((0x280000000000L & l) != 0L)
                     jjCheckNAdd(6);
                  break;
               case 6:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 19)
                     kind = 19;
                  jjCheckNAdd(6);
                  break;
               case 7:
                  if (curChar == 39)
                     jjAddStates(11, 12);
                  break;
               case 8:
                  if ((0xffffff7fffffdbffL & l) != 0L)
                     jjCheckNAdd(9);
                  break;
               case 9:
                  if (curChar == 39 && kind > 24)
                     kind = 24;
                  break;
               case 11:
                  if ((0x8400000000L & l) != 0L)
                     jjCheckNAdd(9);
                  break;
               case 12:
                  if ((0xff000000000000L & l) != 0L)
                     jjCheckNAddTwoStates(13, 9);
                  break;
               case 13:
                  if ((0xff000000000000L & l) != 0L)
                     jjCheckNAdd(9);
                  break;
               case 14:
                  if ((0xf000000000000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 15;
                  break;
               case 15:
                  if ((0xff000000000000L & l) != 0L)
                     jjCheckNAdd(13);
                  break;
               case 16:
                  if (curChar == 34)
                     jjCheckNAddStates(8, 10);
                  break;
               case 17:
                  if ((0xfffffffbffffdbffL & l) != 0L)
                     jjCheckNAddStates(8, 10);
                  break;
               case 19:
                  if ((0x8400000000L & l) != 0L)
                     jjCheckNAddStates(8, 10);
                  break;
               case 20:
                  if (curChar == 34 && kind > 25)
                     kind = 25;
                  break;
               case 21:
                  if ((0xff000000000000L & l) != 0L)
                     jjCheckNAddStates(20, 23);
                  break;
               case 22:
                  if ((0xff000000000000L & l) != 0L)
                     jjCheckNAddStates(8, 10);
                  break;
               case 23:
                  if ((0xf000000000000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 24;
                  break;
               case 24:
                  if ((0xff000000000000L & l) != 0L)
                     jjCheckNAdd(22);
                  break;
               case 26:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 26)
                     kind = 26;
                  jjstateSet[jjnewStateCnt++] = 26;
                  break;
               case 27:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 19)
                     kind = 19;
                  jjCheckNAddStates(0, 5);
                  break;
               case 28:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 19)
                     kind = 19;
                  jjCheckNAddTwoStates(28, 29);
                  break;
               case 30:
                  if ((0x280000000000L & l) != 0L)
                     jjCheckNAdd(31);
                  break;
               case 31:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 19)
                     kind = 19;
                  jjCheckNAdd(31);
                  break;
               case 32:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjCheckNAddTwoStates(32, 33);
                  break;
               case 34:
                  if ((0x280000000000L & l) != 0L)
                     jjCheckNAdd(35);
                  break;
               case 35:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 19)
                     kind = 19;
                  jjCheckNAdd(35);
                  break;
               case 36:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjCheckNAddTwoStates(36, 37);
                  break;
               case 37:
                  if (curChar != 46)
                     break;
                  if (kind > 19)
                     kind = 19;
                  jjCheckNAddTwoStates(38, 39);
                  break;
               case 38:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 19)
                     kind = 19;
                  jjCheckNAddTwoStates(38, 39);
                  break;
               case 40:
                  if ((0x280000000000L & l) != 0L)
                     jjCheckNAdd(41);
                  break;
               case 41:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 19)
                     kind = 19;
                  jjCheckNAdd(41);
                  break;
               case 42:
                  if (curChar == 47)
                     jjAddStates(6, 7);
                  break;
               case 43:
                  if (curChar == 42)
                     jjstateSet[jjnewStateCnt++] = 44;
                  break;
               case 44:
                  if ((0xffff7fffffffffffL & l) != 0L && kind > 6)
                     kind = 6;
                  break;
               case 46:
                  if (curChar != 47)
                     break;
                  if (kind > 8)
                     kind = 8;
                  jjCheckNAddStates(17, 19);
                  break;
               case 47:
                  if ((0xffffffffffffdbffL & l) == 0L)
                     break;
                  if (kind > 8)
                     kind = 8;
                  jjCheckNAddStates(17, 19);
                  break;
               case 48:
                  if ((0x2400L & l) != 0L && kind > 8)
                     kind = 8;
                  break;
               case 49:
                  if (curChar == 10 && kind > 8)
                     kind = 8;
                  break;
               case 50:
                  if (curChar == 13)
                     jjstateSet[jjnewStateCnt++] = 49;
                  break;
               case 51:
                  if (curChar != 48)
                     break;
                  if (kind > 15)
                     kind = 15;
                  jjCheckNAddStates(13, 16);
                  break;
               case 53:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 15)
                     kind = 15;
                  jjstateSet[jjnewStateCnt++] = 53;
                  break;
               case 54:
                  if ((0xff000000000000L & l) == 0L)
                     break;
                  if (kind > 15)
                     kind = 15;
                  jjCheckNAdd(54);
                  break;
               case 56:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjAddStates(24, 25);
                  break;
               case 57:
                  if (curChar == 46)
                     jjCheckNAdd(58);
                  break;
               case 58:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjCheckNAddTwoStates(58, 59);
                  break;
               case 60:
                  if ((0x280000000000L & l) != 0L)
                     jjCheckNAdd(61);
                  break;
               case 61:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 19)
                     kind = 19;
                  jjCheckNAdd(61);
                  break;
               case 63:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjCheckNAddStates(26, 28);
                  break;
               case 64:
                  if (curChar == 46)
                     jjCheckNAdd(65);
                  break;
               case 66:
                  if ((0x280000000000L & l) != 0L)
                     jjCheckNAdd(67);
                  break;
               case 67:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 19)
                     kind = 19;
                  jjCheckNAdd(67);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else if (curChar < 128)
      {
         long l = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 0:
               case 26:
                  if ((0x7fffffe87fffffeL & l) == 0L)
                     break;
                  if (kind > 26)
                     kind = 26;
                  jjCheckNAdd(26);
                  break;
               case 4:
                  if ((0x2000000020L & l) != 0L)
                     jjAddStates(29, 30);
                  break;
               case 8:
                  if ((0xffffffffefffffffL & l) != 0L)
                     jjCheckNAdd(9);
                  break;
               case 10:
                  if (curChar == 92)
                     jjAddStates(31, 33);
                  break;
               case 11:
                  if ((0x14404410000000L & l) != 0L)
                     jjCheckNAdd(9);
                  break;
               case 17:
                  if ((0xffffffffefffffffL & l) != 0L)
                     jjCheckNAddStates(8, 10);
                  break;
               case 18:
                  if (curChar == 92)
                     jjAddStates(34, 36);
                  break;
               case 19:
                  if ((0x14404410000000L & l) != 0L)
                     jjCheckNAddStates(8, 10);
                  break;
               case 29:
                  if ((0x2000000020L & l) != 0L)
                     jjAddStates(37, 38);
                  break;
               case 33:
                  if ((0x2000000020L & l) != 0L)
                     jjAddStates(39, 40);
                  break;
               case 39:
                  if ((0x2000000020L & l) != 0L)
                     jjAddStates(41, 42);
                  break;
               case 44:
                  if (kind > 6)
                     kind = 6;
                  break;
               case 47:
                  if (kind > 8)
                     kind = 8;
                  jjAddStates(17, 19);
                  break;
               case 52:
                  if ((0x100000001000000L & l) != 0L)
                     jjCheckNAdd(53);
                  break;
               case 53:
                  if ((0x7e0000007eL & l) == 0L)
                     break;
                  if (kind > 15)
                     kind = 15;
                  jjCheckNAdd(53);
                  break;
               case 55:
                  if ((0x100000001000000L & l) != 0L)
                     jjCheckNAddTwoStates(56, 57);
                  break;
               case 56:
                  if ((0x7e0000007eL & l) != 0L)
                     jjCheckNAddTwoStates(56, 57);
                  break;
               case 58:
                  if ((0x7e0000007eL & l) != 0L)
                     jjAddStates(43, 44);
                  break;
               case 59:
                  if ((0x1000000010000L & l) != 0L)
                     jjAddStates(45, 46);
                  break;
               case 62:
                  if ((0x100000001000000L & l) != 0L)
                     jjCheckNAdd(63);
                  break;
               case 63:
                  if ((0x7e0000007eL & l) != 0L)
                     jjCheckNAddStates(26, 28);
                  break;
               case 65:
                  if ((0x1000000010000L & l) != 0L)
                     jjAddStates(47, 48);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else
      {
         int hiByte = (int)(curChar >> 8);
         int i1 = hiByte >> 6;
         long l1 = 1L << (hiByte & 077);
         int i2 = (curChar & 0xff) >> 6;
         long l2 = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 8:
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                     jjstateSet[jjnewStateCnt++] = 9;
                  break;
               case 17:
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                     jjAddStates(8, 10);
                  break;
               case 44:
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2) && kind > 6)
                     kind = 6;
                  break;
               case 47:
                  if (!jjCanMove_0(hiByte, i1, i2, l1, l2))
                     break;
                  if (kind > 8)
                     kind = 8;
                  jjAddStates(17, 19);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      if (kind != 0x7fffffff)
      {
         jjmatchedKind = kind;
         jjmatchedPos = curPos;
         kind = 0x7fffffff;
      }
      ++curPos;
      if ((i = jjnewStateCnt) == (startsAt = 68 - (jjnewStateCnt = startsAt)))
         return curPos;
      try { curChar = input_stream.readChar(); }
      catch(java.io.IOException e) { return curPos; }
   }
}
private int jjMoveStringLiteralDfa0_2()
{
   switch(curChar)
   {
      case 42:
         return jjMoveStringLiteralDfa1_2(0x400L);
      default :
         return 1;
   }
}
private int jjMoveStringLiteralDfa1_2(long active0)
{
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      return 1;
   }
   switch(curChar)
   {
      case 47:
         if ((active0 & 0x400L) != 0L)
            return jjStopAtPos(1, 10);
         break;
      default :
         return 2;
   }
   return 2;
}
private int jjMoveStringLiteralDfa0_1()
{
   switch(curChar)
   {
      case 42:
         return jjMoveStringLiteralDfa1_1(0x200L);
      default :
         return 1;
   }
}
private int jjMoveStringLiteralDfa1_1(long active0)
{
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      return 1;
   }
   switch(curChar)
   {
      case 47:
         if ((active0 & 0x200L) != 0L)
            return jjStopAtPos(1, 9);
         break;
      default :
         return 2;
   }
   return 2;
}
static final int[] jjnextStates = {
   28, 29, 32, 33, 36, 37, 45, 46, 17, 18, 20, 8, 10, 52, 54, 55, 
   62, 47, 48, 50, 17, 18, 22, 20, 56, 57, 63, 64, 65, 5, 6, 11, 
   12, 14, 19, 21, 23, 30, 31, 34, 35, 40, 41, 58, 59, 60, 61, 66, 
   67, 
};
private static final boolean jjCanMove_0(int hiByte, int i1, int i2, long l1, long l2)
{
   switch(hiByte)
   {
      case 0:
         return ((jjbitVec2[i2] & l2) != 0L);
      default :
         if ((jjbitVec0[i1] & l1) != 0L)
            return true;
         return false;
   }
}

/** Token literal values. */
public static final String[] jjstrLiteralImages = {
"", null, null, null, null, null, null, null, null, null, null, null, 
"\144\145\146", "\166\141\154", "\166\141\162", null, null, null, null, null, null, null, null, 
null, null, null, null, null, null, "\50", "\51", "\173", "\175", "\133", "\135", 
"\73", "\54", "\56", "\100", "\75", "\74", "\41", "\176", "\77", "\72", "\75\75", 
"\74\75", "\76\75", "\41\75", "\174\174", "\46\46", "\53\53", "\55\55", "\53", "\55", 
"\52", "\57", "\46", "\174", "\136", "\45", "\74\74", "\53\75", "\55\75", "\52\75", 
"\57\75", "\46\75", "\174\75", "\136\75", "\45\75", "\74\74\75", "\76\76\75", 
"\76\76\76\75", "\56\56\56", };

/** Lexer state names. */
public static final String[] lexStateNames = {
   "DEFAULT",
   "IN_FORMAL_COMMENT",
   "IN_MULTI_LINE_COMMENT",
};

/** Lex State array. */
public static final int[] jjnewLexState = {
   -1, -1, -1, -1, -1, -1, 1, 2, -1, 0, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
   -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
   -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
};
static final long[] jjtoToken = {
   0xffffffffe708f001L, 0x3ffL, 
};
static final long[] jjtoSkip = {
   0x73eL, 0x0L, 
};
static final long[] jjtoSpecial = {
   0x700L, 0x0L, 
};
static final long[] jjtoMore = {
   0x8c0L, 0x0L, 
};
protected SimpleCharStream input_stream;
private final int[] jjrounds = new int[68];
private final int[] jjstateSet = new int[136];
private final StringBuilder jjimage = new StringBuilder();
private StringBuilder image = jjimage;
private int jjimageLen;
private int lengthOfMatch;
protected char curChar;
/** Constructor. */
public LexerTokenManager(SimpleCharStream stream){
   if (SimpleCharStream.staticFlag)
      throw new Error("ERROR: Cannot use a static CharStream class with a non-static lexical analyzer.");
   input_stream = stream;
}

/** Constructor. */
public LexerTokenManager(SimpleCharStream stream, int lexState){
   this(stream);
   SwitchTo(lexState);
}

/** Reinitialise parser. */
public void ReInit(SimpleCharStream stream)
{
   jjmatchedPos = jjnewStateCnt = 0;
   curLexState = defaultLexState;
   input_stream = stream;
   ReInitRounds();
}
private void ReInitRounds()
{
   int i;
   jjround = 0x80000001;
   for (i = 68; i-- > 0;)
      jjrounds[i] = 0x80000000;
}

/** Reinitialise parser. */
public void ReInit(SimpleCharStream stream, int lexState)
{
   ReInit(stream);
   SwitchTo(lexState);
}

/** Switch to specified lex state. */
public void SwitchTo(int lexState)
{
   if (lexState >= 3 || lexState < 0)
      throw new TokenMgrError("Error: Ignoring invalid lexical state : " + lexState + ". State unchanged.", TokenMgrError.INVALID_LEXICAL_STATE);
   else
      curLexState = lexState;
}

protected Token jjFillToken()
{
   final Token t;
   final String curTokenImage;
   final int beginLine;
   final int endLine;
   final int beginColumn;
   final int endColumn;
   String im = jjstrLiteralImages[jjmatchedKind];
   curTokenImage = (im == null) ? input_stream.GetImage() : im;
   beginLine = input_stream.getBeginLine();
   beginColumn = input_stream.getBeginColumn();
   endLine = input_stream.getEndLine();
   endColumn = input_stream.getEndColumn();
   t = Token.newToken(jjmatchedKind, curTokenImage);

   t.beginLine = beginLine;
   t.endLine = endLine;
   t.beginColumn = beginColumn;
   t.endColumn = endColumn;

   return t;
}

int curLexState = 0;
int defaultLexState = 0;
int jjnewStateCnt;
int jjround;
int jjmatchedPos;
int jjmatchedKind;

/** Get the next Token. */
public Token getNextToken() 
{
  Token specialToken = null;
  Token matchedToken;
  int curPos = 0;

  EOFLoop :
  for (;;)
  {
   try
   {
      curChar = input_stream.BeginToken();
   }
   catch(java.io.IOException e)
   {
      jjmatchedKind = 0;
      matchedToken = jjFillToken();
      matchedToken.specialToken = specialToken;
      return matchedToken;
   }
   image = jjimage;
   image.setLength(0);
   jjimageLen = 0;

   for (;;)
   {
     switch(curLexState)
     {
       case 0:
         try { input_stream.backup(0);
            while (curChar <= 32 && (0x100003600L & (1L << curChar)) != 0L)
               curChar = input_stream.BeginToken();
         }
         catch (java.io.IOException e1) { continue EOFLoop; }
         jjmatchedKind = 0x7fffffff;
         jjmatchedPos = 0;
         curPos = jjMoveStringLiteralDfa0_0();
         break;
       case 1:
         jjmatchedKind = 0x7fffffff;
         jjmatchedPos = 0;
         curPos = jjMoveStringLiteralDfa0_1();
         if (jjmatchedPos == 0 && jjmatchedKind > 11)
         {
            jjmatchedKind = 11;
         }
         break;
       case 2:
         jjmatchedKind = 0x7fffffff;
         jjmatchedPos = 0;
         curPos = jjMoveStringLiteralDfa0_2();
         if (jjmatchedPos == 0 && jjmatchedKind > 11)
         {
            jjmatchedKind = 11;
         }
         break;
     }
     if (jjmatchedKind != 0x7fffffff)
     {
        if (jjmatchedPos + 1 < curPos)
           input_stream.backup(curPos - jjmatchedPos - 1);
        if ((jjtoToken[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L)
        {
           matchedToken = jjFillToken();
           matchedToken.specialToken = specialToken;
       if (jjnewLexState[jjmatchedKind] != -1)
         curLexState = jjnewLexState[jjmatchedKind];
           return matchedToken;
        }
        else if ((jjtoSkip[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L)
        {
           if ((jjtoSpecial[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L)
           {
              matchedToken = jjFillToken();
              if (specialToken == null)
                 specialToken = matchedToken;
              else
              {
                 matchedToken.specialToken = specialToken;
                 specialToken = (specialToken.next = matchedToken);
              }
              SkipLexicalActions(matchedToken);
           }
           else
              SkipLexicalActions(null);
         if (jjnewLexState[jjmatchedKind] != -1)
           curLexState = jjnewLexState[jjmatchedKind];
           continue EOFLoop;
        }
        MoreLexicalActions();
      if (jjnewLexState[jjmatchedKind] != -1)
        curLexState = jjnewLexState[jjmatchedKind];
        curPos = 0;
        jjmatchedKind = 0x7fffffff;
        try {
           curChar = input_stream.readChar();
           continue;
        }
        catch (java.io.IOException e1) { }
     }
     int error_line = input_stream.getEndLine();
     int error_column = input_stream.getEndColumn();
     String error_after = null;
     boolean EOFSeen = false;
     try { input_stream.readChar(); input_stream.backup(1); }
     catch (java.io.IOException e1) {
        EOFSeen = true;
        error_after = curPos <= 1 ? "" : input_stream.GetImage();
        if (curChar == '\n' || curChar == '\r') {
           error_line++;
           error_column = 0;
        }
        else
           error_column++;
     }
     if (!EOFSeen) {
        input_stream.backup(1);
        error_after = curPos <= 1 ? "" : input_stream.GetImage();
     }
     throw new TokenMgrError(EOFSeen, curLexState, error_line, error_column, error_after, curChar, TokenMgrError.LEXICAL_ERROR);
   }
  }
}

void SkipLexicalActions(Token matchedToken)
{
   switch(jjmatchedKind)
   {
      default :
         break;
   }
}
void MoreLexicalActions()
{
   jjimageLen += (lengthOfMatch = jjmatchedPos + 1);
   switch(jjmatchedKind)
   {
      case 6 :
         image.append(input_stream.GetSuffix(jjimageLen));
         jjimageLen = 0;
                   input_stream.backup(1);
         break;
      default :
         break;
   }
}
private void jjCheckNAdd(int state)
{
   if (jjrounds[state] != jjround)
   {
      jjstateSet[jjnewStateCnt++] = state;
      jjrounds[state] = jjround;
   }
}
private void jjAddStates(int start, int end)
{
   do {
      jjstateSet[jjnewStateCnt++] = jjnextStates[start];
   } while (start++ != end);
}
private void jjCheckNAddTwoStates(int state1, int state2)
{
   jjCheckNAdd(state1);
   jjCheckNAdd(state2);
}

private void jjCheckNAddStates(int start, int end)
{
   do {
      jjCheckNAdd(jjnextStates[start]);
   } while (start++ != end);
}

}
