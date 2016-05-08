/*
 * AsyncWorldEdit API
 * Copyright (c) 2015, SBPrime <https://github.com/SBPrime/>
 * Copyright (c) AsyncWorldEdit API contributors
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted free of charge provided that the following 
 * conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer. 
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution,
 * 3. Redistributions of source code, with or without modification, in any form 
 *    other then free of charge is not allowed,
 * 4. Redistributions in binary form in any form other then free of charge is 
 *    not allowed.
 * 5. Any derived work based on or containing parts of this software must reproduce 
 *    the above copyright notice, this list of conditions and the following 
 *    disclaimer in the documentation and/or other materials provided with the 
 *    derived work.
 * 6. The original author of the software is allowed to change the license 
 *    terms or the entire license of the software as he sees fit.
 * 7. The original author of the software is allowed to sublicense the software 
 *    or its parts using any license terms he sees fit.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.primesoft.asyncworldedit.api.directChunk;

import com.sk89q.jnbt.CompoundTag;
import com.sk89q.worldedit.Vector;
import com.sk89q.worldedit.blocks.BaseBlock;
import java.util.UUID;
import org.bukkit.Chunk;
import org.bukkit.Material;
import org.primesoft.asyncworldedit.api.playerManager.IPlayerEntry;
import org.primesoft.asyncworldedit.api.utils.IInOutParam;

/**
 * The direct chunk API class
 * @author SBPrime
 */
public interface IDirectChunkAPI {
    /**
     * Wrap bukkit chunk into direct chunk api
     * @param chunk
     * @param player
     * @return 
     */
    IWrappedChunk wrapChunk(Chunk chunk, IPlayerEntry player);
    
    
    /**
     * Create an empty chunk data
     * @return 
     */
    IChunkData createChunkData();
    
    
    /**
     * Create an lazy chunk data
     * @param chunk
     * @return 
     */
    IChangesetChunkData createLazyChunkData(IWrappedChunk chunk);
    
    
    /**
     * Converts material and data to chunk section id
     * @param m
     * @param data
     * @return 
     */
    char getCombinedId(Material m, int data);
    
    
    /**
     * Converts type and data to chunk section id
     * @param type
     * @param data
     * @return 
     */
    char getCombinedId(int type, int data);
    
    
    /**
     * Get WorldEdit base blocks
     * @param type
     * @param nbt
     * @return 
     */
    BaseBlock getBaseBlock(char type, CompoundTag nbt);
    
    
    /**
     * Convert combined ID to Material and data
     * @param combinedId
     * @param data
     * @return
     */
    Material convertId(char combinedId, IInOutParam<Integer> data);
    
    
    /**
     * Create new instance of serialized entity
     * @param uuid
     * @param position
     * @param yaw
     * @param pitch
     * @param nbt
     * @return 
     */
    ISerializedEntity createEntity(UUID uuid, Vector position,
            float yaw, float pitch, byte[] nbt);
}
