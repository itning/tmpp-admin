package top.itning.tmpp.tmppadmin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.GlobalMemory;
import oshi.hardware.HardwareAbstractionLayer;

/**
 * @author itning
 * @date 2019/6/22 20:18
 */
@RestController
@RequestMapping("/system")
public class SystemController {

    private final CentralProcessor processor;
    private final GlobalMemory memory;

    public SystemController() {
        SystemInfo si = new SystemInfo();
        HardwareAbstractionLayer hardware = si.getHardware();
        processor = hardware.getProcessor();
        memory = hardware.getMemory();
    }

    @GetMapping("/systemCpuLoad")
    public int getSystemCpuLoad() {
        return (int) (processor.getSystemCpuLoad() * 100);
    }

    @GetMapping("/memoryAvailable")
    public long getMemoryAvailable() {
        return memory.getAvailable();
    }

    @GetMapping("/memoryTotal")
    public long getMemoryTotal() {
        return memory.getTotal();
    }
}
