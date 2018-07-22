/*
 * CalypsoFile.java
 *
 * Copyright 2018 Michael Farrell <micolous+git@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package au.id.micolous.metrodroid.card.calypso;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

import au.id.micolous.metrodroid.card.iso7816.ISO7816Record;

/**
 * Represents a file on a Calypso card.
 */
@Root(name = "file")
public class CalypsoFile {
    @Attribute(name = "file")
    private int mFileId;
    @Attribute(name = "folder")
    private int mFolderId;
    @ElementList(name = "records", required = false, empty = false)
    private List<ISO7816Record> mRecords;

    CalypsoFile() { /* For XML Serializer */ }

    CalypsoFile(int folderId, int fileId, List<ISO7816Record> records) {
        mFolderId = folderId;
        mFileId = fileId;
        mRecords = records;
    }

    public int getFile() {
        return mFileId;
    }

    public int getFolder() {
        return mFolderId;
    }

    public List<ISO7816Record> getRecords() {
        return mRecords;
    }

    /**
     * Gets a record for a given index.
     * @param index Record index to retrieve.
     * @return ISO7816Record with that index, or null if not present.
     */
    public ISO7816Record getRecord(int index) {
        for (ISO7816Record record : mRecords) {
            if (record.getIndex() == index) {
                return record;
            }
        }

        return null;
    }
}
