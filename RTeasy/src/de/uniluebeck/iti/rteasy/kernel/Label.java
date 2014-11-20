/*
 * Copyright (c) 2003-2013, University of Luebeck, Institute of Computer Engineering
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *     * Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the distribution.
 *     * Neither the name of the University of Luebeck, the Institute of Computer
 *       Engineering nor the names of its contributors may be used to endorse or
 *       promote products derived from this software without specific prior
 *       written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 * IN NO EVENT SHALL THE UNIVERSITY OF LUEBECK OR THE INSTITUTE OF COMPUTER
 * ENGINEERING BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY,
 * OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE
 * GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR
 * TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 */


package de.uniluebeck.iti.rteasy.kernel;
import de.uniluebeck.iti.rteasy.PositionRange;

public class Label extends SimulationObject {
  private int statSeqEntry, parStatsEntry;

  Label(String s, PositionRange tpr) {
    super(s,tpr);
  }

  public void setEntry(int seqE, int statsE) {
    statSeqEntry = seqE;
    parStatsEntry = statsE;
  }

  public void insertUpdate(int insertIndex) {
    if(insertIndex <= statSeqEntry) statSeqEntry++;
  }
  public int getStatSeqEntry() { return statSeqEntry; }
  public int getParStatsEntry() { return parStatsEntry; }
  public String toString() { return getIdStr()+" => ("+statSeqEntry+
                             ","+parStatsEntry+")"; }
  public String infoStr() {
    return "Label "+getIdStr()+" statSeqIdx="+statSeqEntry
      +" parStatsIdx="+parStatsEntry+" Pos: "+getPositionRange().toString();
  }

  public boolean equals(Object o) {
    if(o instanceof Label) return statSeqEntry == ((Label) o).getStatSeqEntry()
			    && parStatsEntry == ((Label) o).getParStatsEntry();
    else return false;
  }

  /**
   * @return statSeqEntry (is only used after RTProgram.performTransformations() was called)
   */
  public int hashCode() { return statSeqEntry; }

  public String getVHDLName() { return "label_"+getIdStr(); }
}
