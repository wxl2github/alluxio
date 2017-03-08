/*
 * The Alluxio Open Foundation licenses this work under the Apache License, version 2.0
 * (the "License"). You may not use this work except in compliance with the License, which is
 * available at www.apache.org/licenses/LICENSE-2.0
 *
 * This software is distributed on an "AS IS" basis, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied, as more fully set forth in the License.
 *
 * See the NOTICE file distributed with this work for information regarding copyright ownership.
 */

package alluxio.master.journal.ufs;

import alluxio.master.journal.JournalReader;
import alluxio.master.journal.ReadOnlyJournal;

import java.net.URL;

import javax.annotation.concurrent.ThreadSafe;

/**
 * The read-only journal. It prevents access to a {@link UfsJournalWriter}.
 */
@ThreadSafe
public class ReadOnlyUfsJournal extends UfsJournal implements ReadOnlyJournal {
  /**
   * @param location the location for the journal
   */
  public ReadOnlyUfsJournal(URL location) {
    super(location);
  }

  /**
   * @return the {@link UfsJournalReader} for this journal
   */
  public JournalReader getNewReader() {
    return new UfsJournalReader(this);
  }
}
