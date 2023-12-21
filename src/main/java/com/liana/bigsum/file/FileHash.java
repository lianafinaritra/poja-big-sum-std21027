package com.liana.bigsum.file;

import com.liana.bigsum.PojaGenerated;

@PojaGenerated
public record FileHash(FileHashAlgorithm algorithm, String value) {}
